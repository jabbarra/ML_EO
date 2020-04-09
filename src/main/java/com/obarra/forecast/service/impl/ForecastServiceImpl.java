package com.obarra.forecast.service.impl;

import com.obarra.forecast.bean.Weather;
import com.obarra.forecast.dto.ForecastRainDTO;
import com.obarra.forecast.dto.ForecastDTO;
import com.obarra.forecast.enums.WeatherEnum;
import com.obarra.forecast.mapper.DayMapper;
import com.obarra.forecast.mapper.WeatherMapper;
import com.obarra.forecast.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.obarra.forecast.enums.WeatherEnum.DROUGHT;
import static com.obarra.forecast.enums.WeatherEnum.OPTIMUM;
import static com.obarra.forecast.enums.WeatherEnum.RAIN;

@Service
public class ForecastServiceImpl implements ForecastService {
    private final WeatherMapper weatherMapper;
    private final DayMapper dayMapper;

    @Autowired
    public ForecastServiceImpl(final WeatherMapper weatherMapper,
                               final DayMapper diaMapper) {
        this.dayMapper = diaMapper;
        this.weatherMapper = weatherMapper;
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public ForecastDTO getDroughtPeriods() {
        return generateReport(DROUGHT);
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public ForecastDTO getOptimumPeriods() {
        return generateReport(OPTIMUM);
    }


    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public ForecastDTO getRainPeriods() {
        final ForecastDTO reportDTO = generateReport(RAIN);

        final ForecastRainDTO rainReportDTO = new ForecastRainDTO();
        rainReportDTO.setWeather(reportDTO.getWeather());
        rainReportDTO.setQuantityPeriods(reportDTO.getQuantityPeriods());

        rainReportDTO.setMaximumIntensityDay(dayMapper.findMaximumRainIntensityDay());

        return rainReportDTO;
    }

    private ForecastDTO generateReport(final WeatherEnum weatherEnum) {
        final Weather weather = weatherMapper.findById(weatherEnum.value());
        final ForecastDTO reportDTO = new ForecastDTO();
        reportDTO.setWeather(weather);

        reportDTO.setQuantityPeriods(dayMapper
                .countPeriodsOfWeatherType(weatherEnum.value()));
        return reportDTO;
    }

}
