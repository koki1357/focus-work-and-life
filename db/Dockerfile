FROM mysql:8.0

# ポートの設定
EXPOSE 3306

# MySQL設定ファイルをコピー
COPY ./my.cnf /etc/mysql/conf.d/my.cnf

# コンテナ内の/docker-entrypoint-initdb.d/配下にDB初期化用のSQLファイルを配置
COPY ./initdb.d/init.sql /docker-entrypoint-initdb.d/

CMD ["mysqld"]