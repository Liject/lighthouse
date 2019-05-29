# Copyright (C) MakeIN <http://www.makein.kro.kr>

# @auther MakeIN (hyeokju1313@naver.com, liject.member@gmail.com)
# @file backend/rest,py
# @brief LightHouse backend REST API Code
# @version 1.0.0
# GitHub PAGE <https://github.com/Team-Makein/Lighthouse>

from flask import Flask
from flask_restful import Resource, Api, reqparse
from flaskext.mysql import MySQL
from datetime import datetime, date

app = Flask(__name__)
api = Api(app)


# Mysql Connection
db = MySQL()
app.config['MYSQL_DATABASE_USER'] = 'lighthouse'
app.config['MYSQL_DATABASE_PASSWORD'] = 'entaro'
app.config['MYSQL_DATABASE_DB'] = 'lighthouse'
app.config['MYSQL_DATABASE_HOST'] = '127.0.0.1'
db.init_app(app)


class Registration(Resource):
    def post(self):
        try:
            parser = reqparse.RequestParser()
            parser.add_argument('login_id', type=str)
            parser.add_argument('password', type=str)
            parser.add_argument('name', type=str)
            parser.add_argument('email', type=str)
            args = parser.parse_args()

            _login_id = args['login_id']
            _password = args['password']
            _name = args['name']
            _email = args['email']
            _created = datetime.now()

            conn = db.connect()
            cursor = conn.cursor()
            cursor.callproc('registration',(_login_id, _password, _name, _email, _created))
            data = cursor.fetchall()

            if len(data) is 0:
                conn.commit()
                return {'StatusCode': '200', 'Message': 'User creation success'}
            else:
                return {'StatusCode': '1000', 'Message': str(data[0])}

        except Exception as e:
            return {'error': str(e)}


class Login(Resource):
    def post(self):
        try:
            parser = reqparse.RequestParser()
            parser.add_argument('login_id', type=str)
            parser.add_argument('password', type=str)
            args = parser.parse_args()

            _login_id = args['login_id']
            _password = args['password']

            conn = db.connect()
            cursor = conn.cursor()
            cursor.callproc('login', (_login_id, _password))
            data = cursor.fetchall()

            if len(data) is 0:
                return {'StatusCode': '200', 'Message': 'Login success'}, {'Set-Cookie': 'current_user='+str(_login_id)}
            else:
                return {'StatusCode': '1000', 'Message': str(data[0])}

        except Exception as e:
            return {'error': str(e)}


class Write(Resource):
    def post(self):
        try:
            parser = reqparse.RequestParser()
            parser.add_argument('current_user', type=str)
            parser.add_argument('title', type=str)
            parser.add_argument('content', type=str)
            args = parser.parse_args()

            _current_user = args['current_user']
            _title = args['title']
            _content = args['content']
            _date = date.today()


            query = '''INSERT INTO voyage_record (uid, title, content, date)
                                VALUES ((SELECT id FROM users WHERE login_id = \''''+_current_user+'''\')
                                , \''''+_title+'''\',\''''+_content+'''\',\''''+str(_date)+'''\');'''

            print(query)
            conn = db.connect()
            cursor = conn.cursor()
            cursor.execute(query)
            data = cursor.fetchall()

            if len(data) is 0:
                conn.commit()
                return {'StatusCode': '200', 'Message': 'Write post success'}
            else:
                return {'StatusCode': '1000', 'Message': str(data[0])}

        except Exception as e:
            return {'error': str(e)}

class View(Resource):
    def post(self):
        try:
            parser = reqparse.RequestParser()
            parser.add_argument('current_user', type=str)
            args = parser.parse_args()

            _current_user = args['current_user']


            query = '''SELECT * FROM voyage_record WHERE uid=
                                (SELECT id FROM users WHERE login_id=\''''+_current_user+'''\');'''


            print(query)

            conn = db.connect()
            cursor = conn.cursor()
            cursor.execute(query)
            row_headers = [x[0] for x in cursor.description]
            data = cursor.fetchall()

            json_data=[]

            for result in data:
                json_data.append(dict(zip(row_headers,result)))

            if len(data) is 0:
                return {'StatusCode': '404', 'Message': 'No your post on DB'}
            else:
                return {'StatusCode': '200', 'Message': str(data)}

        except Exception as e:
            return {'error': str(e)}


api.add_resource(Registration, '/registration')
api.add_resource(Login, '/login')
api.add_resource(Write, '/write')
api.add_resource(View, '/view')

if __name__ == '__main__':
    app.run(debug=True)
