import { Sequelize } from 'sequelize';
import mysql2 from 'mysql2';
import DebugLib from 'debug';
import config from 'config';

const debug = new DebugLib('server:mysql');

const dbHost= process.env.MYSQLHOST || config.get('mysqlHost');
const dbUser= process.env.DB_USER || config.get('mysqlUser');
const dbPassword= process.env.DB_PASS || config.get('mysqlPassword');

export default new Sequelize('eoloplantsDB', dbUser, dbPassword, {
    host: dbHost,
    dialect: 'mysql',
    dialectModule: mysql2,
    logging: false
});

process.on('exit', async () => {
    await sequelize.close();
    debug(`Closing mysql connection`);
});
