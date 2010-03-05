/*
 * Copyright (c) 2009 Mysema Ltd.
 * All rights reserved.
 * 
 */
package com.mysema.query.support;

import com.mysema.query.Detachable;
import com.mysema.query.QueryBase;
import com.mysema.query.QueryMixin;
import com.mysema.query.types.expr.EBoolean;
import com.mysema.query.types.expr.EComparable;
import com.mysema.query.types.expr.EDate;
import com.mysema.query.types.expr.EDateTime;
import com.mysema.query.types.expr.ENumber;
import com.mysema.query.types.expr.EString;
import com.mysema.query.types.expr.ETime;
import com.mysema.query.types.expr.Expr;
import com.mysema.query.types.query.BooleanSubQuery;
import com.mysema.query.types.query.ComparableSubQuery;
import com.mysema.query.types.query.DateSubQuery;
import com.mysema.query.types.query.DateTimeSubQuery;
import com.mysema.query.types.query.ListSubQuery;
import com.mysema.query.types.query.NumberSubQuery;
import com.mysema.query.types.query.ObjectSubQuery;
import com.mysema.query.types.query.StringSubQuery;
import com.mysema.query.types.query.TimeSubQuery;

/**
 * @author tiwe
 *
 * @param <SubType>
 */
public class DetachableQuery <SubType extends DetachableQuery<SubType>> extends QueryBase<SubType> implements Detachable {

    private final DetachableMixin detachableMixin;
    
    public DetachableQuery(QueryMixin<SubType> queryMixin) {
        super(queryMixin);
        this.detachableMixin = new DetachableMixin(queryMixin);
    }
    
    @Override
    public ObjectSubQuery<Long> count(){
        return detachableMixin.count();
    }
    
    @Override
    public EBoolean exists(){
        return detachableMixin.exists();
    }
    
    @Override
    public ListSubQuery<Object[]> list(Expr<?> first, Expr<?> second, Expr<?>... rest) {
        return detachableMixin.list(first, second, rest);
    }
    
    @Override
    public ListSubQuery<Object[]> list(Expr<?>[] args) {
        return detachableMixin.list(args);
    }

    @Override
    public <RT> ListSubQuery<RT> list(Expr<RT> projection) {
        return detachableMixin.list(projection);
    }

    @Override
    public EBoolean notExists(){
        return detachableMixin.notExists();
    }

    @Override
    public BooleanSubQuery unique(EBoolean projection) {
        return detachableMixin.unique(projection);
    }

    @Override
    public <RT extends Comparable<?>> ComparableSubQuery<RT> unique(EComparable<RT> projection) {
        return detachableMixin.unique(projection);
    }

    @Override
    public <RT extends Comparable<?>> DateSubQuery<RT> unique(EDate<RT> projection) {
        return detachableMixin.unique(projection);
    }

    @Override
    public <RT extends Comparable<?>> DateTimeSubQuery<RT> unique(EDateTime<RT> projection) {
        return detachableMixin.unique(projection);
    }

    @Override
    public <RT extends Number & Comparable<?>> NumberSubQuery<RT> unique(ENumber<RT> projection) {
        return detachableMixin.unique(projection);
    }

    @Override
    public StringSubQuery unique(EString projection) {
        return detachableMixin.unique(projection);
    }

    @Override
    public <RT extends Comparable<?>> TimeSubQuery<RT> unique(ETime<RT> projection) {
        return detachableMixin.unique(projection);
    }

    @Override
    public ObjectSubQuery<Object[]> unique(Expr<?> first, Expr<?> second, Expr<?>... rest) {
        return detachableMixin.unique(first, second, rest);
    }

    @Override
    public ObjectSubQuery<Object[]> unique(Expr<?>[] args) {
        return detachableMixin.unique(args);
    }

    @Override
    public <RT> ObjectSubQuery<RT> unique(Expr<RT> projection) {
        return detachableMixin.unique(projection);
    }

}
