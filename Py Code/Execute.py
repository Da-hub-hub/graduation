import data


if __name__=='__main__':
    data=data.Data
    data().do_clean_table()
    data().get_provence_data()
    data().get_china_daily_data()
    data().get_china_total_data()
    data().get_global_today_data()
    data().get_global_total_data()
