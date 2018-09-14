package com.work.practice.log4j2;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

import static org.apache.logging.log4j.message.ParameterizedMessage.deepToString;

/**
 * @author wangkai43
 * @create 2018-09-12-19:47
 * @email wangkai43@meituan.com
 */
@Plugin(name = "SensitiveDataFilter", category = Node.CATEGORY, elementType = Filter.ELEMENT_TYPE, printObject = true)
public class SensitiveDataFilter extends AbstractFilter {
    private static final long serialVersionUID = 1L;

    private final boolean enabled;

    public SensitiveDataFilter(boolean enabled, Result onMatch, Result onMismatch) {
        super(onMatch, onMismatch);
        this.enabled = enabled;
    }

    @Override
    public Result filter(final LogEvent event) {
        Message message = event.getMessage();
        String str = message.getFormattedMessage();
        try {
            JSONArray jsonArray = (JSONArray) JSONArray.parse(str);
            for(Object o : jsonArray){
                System.out.println(JSON.toJSONString(o));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(">>>>>>>>nature one" + JSON.toJSONString(str));

        return Result.NEUTRAL;
    }


    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final Message msg,
                         final Throwable t) {
        System.out.println(">>>>>>>>nature five");
        return Result.NEUTRAL;
    }


    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final Object msg,
                         final Throwable t) {
        System.out.println(">>>>>>>>nature five2");
        JSONArray jsonArray = (JSONArray) JSONArray.parse(String.valueOf(msg));
        for(Object str : jsonArray){
            System.out.println(String.valueOf(str));
        }
        return filter(logger, level, marker, null, msg);
    }


    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0) {
        System.out.println(">>>>>>>>nature five3");
        return filter(logger, level, marker, msg, new Object[] {p0});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1) {

        System.out.println(">>>>>>>>nature six");
        return filter(logger, level, marker, msg, new Object[] {p0, p1});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2) {

        System.out.println(">>>>>>>>nature seven "+ msg + p0+ p1 + p2 );


        return filter(logger, level, marker, msg, new Object[] {p0, p1, p2});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3) {

        System.out.println(">>>>>>>>nature eight");
        return filter(logger, level, marker, msg, new Object[] {p0, p1, p2, p3});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4) {
        System.out.println(">>>>>>>>nature nine");
        return filter(logger, level, marker, msg, new Object[] {p0, p1, p2, p3, p4});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5) {
        System.out.println(">>>>>>>>nature ten");
        return filter(logger, level, marker, msg, new Object[] {p0, p1, p2, p3, p4, p5});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5, final Object p6) {
        System.out.println(">>>>>>>>nature eleven");
        return filter(logger, level, marker, msg, new Object[] {p0, p1, p2, p3, p4, p5, p6});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5, final Object p6,
                         final Object p7) {
        System.out.println(">>>>>>>>nature twelve");
        return filter(logger, level, marker, msg, new Object[] {p0, p1, p2, p3, p4, p5, p6, p7});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5, final Object p6,
                         final Object p7, final Object p8) {
        System.out.println(">>>>>>>>nature thirteen");
        return filter(logger, level, marker, msg, new Object[] {p0, p1, p2, p3, p4, p5, p6, p7, p8});
    }

    @Override
    public Result filter(final Logger logger, final Level level, final Marker marker, final String msg,
                         final Object p0, final Object p1, final Object p2, final Object p3,
                         final Object p4, final Object p5, final Object p6,
                         final Object p7, final Object p8, final Object p9) {
        System.out.println(">>>>>>>>nature fourteen");
        return filter(logger, level, marker, msg, new Object[] {p0, p1, p2, p3, p4, p5, p6, p7, p8, p9});
    }

    @Override
    public Result filter(Logger logger, Level level, Marker marker, String msg, Object... params) {

        System.out.println(">>>>>>msg Object params");

        if (this.enabled == false) {
            return onMatch;
        }
        if (level == null || logger.getLevel().intLevel() < level.intLevel()) {
            return onMismatch;
        }
        if (params == null || params.length <= 0) {
            return super.filter(logger, level, marker, msg, params);
        }
        for (int i = 0; i < params.length; i++) {
            params[i] = deepToString(params[i]);
        }
        return onMatch;
    }



    @PluginFactory
    public static SensitiveDataFilter createFilter(@PluginAttribute("enabled") final Boolean enabled,
                                                  @PluginAttribute("onMatch") final Result match,
                                                  @PluginAttribute("onMismatch") final Result mismatch) throws IllegalArgumentException,
            IllegalAccessException {
        return new SensitiveDataFilter(enabled, match, mismatch);
    }
}
