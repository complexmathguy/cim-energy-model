import React, { Component } from 'react'
import GovHydroRService from '../services/GovHydroRService';

class CreateGovHydroRComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                at: '',
                db1: '',
                db2: '',
                dturb: '',
                eps: '',
                gmax: '',
                gmin: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                gv6: '',
                h0: '',
                inputSignal: '',
                kg: '',
                ki: '',
                mwbase: '',
                pgv1: '',
                pgv2: '',
                pgv3: '',
                pgv4: '',
                pgv5: '',
                pgv6: '',
                pmax: '',
                pmin: '',
                qnl: '',
                r: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                t7: '',
                t8: '',
                td: '',
                tp: '',
                tt: '',
                tw: '',
                velcl: '',
                velop: ''
        }
        this.changeatHandler = this.changeatHandler.bind(this);
        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changedb2Handler = this.changedb2Handler.bind(this);
        this.changedturbHandler = this.changedturbHandler.bind(this);
        this.changeepsHandler = this.changeepsHandler.bind(this);
        this.changegmaxHandler = this.changegmaxHandler.bind(this);
        this.changegminHandler = this.changegminHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changegv6Handler = this.changegv6Handler.bind(this);
        this.changeh0Handler = this.changeh0Handler.bind(this);
        this.changeinputSignalHandler = this.changeinputSignalHandler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepgv1Handler = this.changepgv1Handler.bind(this);
        this.changepgv2Handler = this.changepgv2Handler.bind(this);
        this.changepgv3Handler = this.changepgv3Handler.bind(this);
        this.changepgv4Handler = this.changepgv4Handler.bind(this);
        this.changepgv5Handler = this.changepgv5Handler.bind(this);
        this.changepgv6Handler = this.changepgv6Handler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changeqnlHandler = this.changeqnlHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changet7Handler = this.changet7Handler.bind(this);
        this.changet8Handler = this.changet8Handler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changettHandler = this.changettHandler.bind(this);
        this.changetwHandler = this.changetwHandler.bind(this);
        this.changevelclHandler = this.changevelclHandler.bind(this);
        this.changevelopHandler = this.changevelopHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovHydroRService.getGovHydroRById(this.state.id).then( (res) =>{
                let govHydroR = res.data;
                this.setState({
                    at: govHydroR.at,
                    db1: govHydroR.db1,
                    db2: govHydroR.db2,
                    dturb: govHydroR.dturb,
                    eps: govHydroR.eps,
                    gmax: govHydroR.gmax,
                    gmin: govHydroR.gmin,
                    gv1: govHydroR.gv1,
                    gv2: govHydroR.gv2,
                    gv3: govHydroR.gv3,
                    gv4: govHydroR.gv4,
                    gv5: govHydroR.gv5,
                    gv6: govHydroR.gv6,
                    h0: govHydroR.h0,
                    inputSignal: govHydroR.inputSignal,
                    kg: govHydroR.kg,
                    ki: govHydroR.ki,
                    mwbase: govHydroR.mwbase,
                    pgv1: govHydroR.pgv1,
                    pgv2: govHydroR.pgv2,
                    pgv3: govHydroR.pgv3,
                    pgv4: govHydroR.pgv4,
                    pgv5: govHydroR.pgv5,
                    pgv6: govHydroR.pgv6,
                    pmax: govHydroR.pmax,
                    pmin: govHydroR.pmin,
                    qnl: govHydroR.qnl,
                    r: govHydroR.r,
                    t1: govHydroR.t1,
                    t2: govHydroR.t2,
                    t3: govHydroR.t3,
                    t4: govHydroR.t4,
                    t5: govHydroR.t5,
                    t6: govHydroR.t6,
                    t7: govHydroR.t7,
                    t8: govHydroR.t8,
                    td: govHydroR.td,
                    tp: govHydroR.tp,
                    tt: govHydroR.tt,
                    tw: govHydroR.tw,
                    velcl: govHydroR.velcl,
                    velop: govHydroR.velop
                });
            });
        }        
    }
    saveOrUpdateGovHydroR = (e) => {
        e.preventDefault();
        let govHydroR = {
                govHydroRId: this.state.id,
                at: this.state.at,
                db1: this.state.db1,
                db2: this.state.db2,
                dturb: this.state.dturb,
                eps: this.state.eps,
                gmax: this.state.gmax,
                gmin: this.state.gmin,
                gv1: this.state.gv1,
                gv2: this.state.gv2,
                gv3: this.state.gv3,
                gv4: this.state.gv4,
                gv5: this.state.gv5,
                gv6: this.state.gv6,
                h0: this.state.h0,
                inputSignal: this.state.inputSignal,
                kg: this.state.kg,
                ki: this.state.ki,
                mwbase: this.state.mwbase,
                pgv1: this.state.pgv1,
                pgv2: this.state.pgv2,
                pgv3: this.state.pgv3,
                pgv4: this.state.pgv4,
                pgv5: this.state.pgv5,
                pgv6: this.state.pgv6,
                pmax: this.state.pmax,
                pmin: this.state.pmin,
                qnl: this.state.qnl,
                r: this.state.r,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                t5: this.state.t5,
                t6: this.state.t6,
                t7: this.state.t7,
                t8: this.state.t8,
                td: this.state.td,
                tp: this.state.tp,
                tt: this.state.tt,
                tw: this.state.tw,
                velcl: this.state.velcl,
                velop: this.state.velop
            };
        console.log('govHydroR => ' + JSON.stringify(govHydroR));

        // step 5
        if(this.state.id === '_add'){
            govHydroR.govHydroRId=''
            GovHydroRService.createGovHydroR(govHydroR).then(res =>{
                this.props.history.push('/govHydroRs');
            });
        }else{
            GovHydroRService.updateGovHydroR(govHydroR).then( res => {
                this.props.history.push('/govHydroRs');
            });
        }
    }
    
    changeatHandler= (event) => {
        this.setState({at: event.target.value});
    }
    changedb1Handler= (event) => {
        this.setState({db1: event.target.value});
    }
    changedb2Handler= (event) => {
        this.setState({db2: event.target.value});
    }
    changedturbHandler= (event) => {
        this.setState({dturb: event.target.value});
    }
    changeepsHandler= (event) => {
        this.setState({eps: event.target.value});
    }
    changegmaxHandler= (event) => {
        this.setState({gmax: event.target.value});
    }
    changegminHandler= (event) => {
        this.setState({gmin: event.target.value});
    }
    changegv1Handler= (event) => {
        this.setState({gv1: event.target.value});
    }
    changegv2Handler= (event) => {
        this.setState({gv2: event.target.value});
    }
    changegv3Handler= (event) => {
        this.setState({gv3: event.target.value});
    }
    changegv4Handler= (event) => {
        this.setState({gv4: event.target.value});
    }
    changegv5Handler= (event) => {
        this.setState({gv5: event.target.value});
    }
    changegv6Handler= (event) => {
        this.setState({gv6: event.target.value});
    }
    changeh0Handler= (event) => {
        this.setState({h0: event.target.value});
    }
    changeinputSignalHandler= (event) => {
        this.setState({inputSignal: event.target.value});
    }
    changekgHandler= (event) => {
        this.setState({kg: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepgv1Handler= (event) => {
        this.setState({pgv1: event.target.value});
    }
    changepgv2Handler= (event) => {
        this.setState({pgv2: event.target.value});
    }
    changepgv3Handler= (event) => {
        this.setState({pgv3: event.target.value});
    }
    changepgv4Handler= (event) => {
        this.setState({pgv4: event.target.value});
    }
    changepgv5Handler= (event) => {
        this.setState({pgv5: event.target.value});
    }
    changepgv6Handler= (event) => {
        this.setState({pgv6: event.target.value});
    }
    changepmaxHandler= (event) => {
        this.setState({pmax: event.target.value});
    }
    changepminHandler= (event) => {
        this.setState({pmin: event.target.value});
    }
    changeqnlHandler= (event) => {
        this.setState({qnl: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet2Handler= (event) => {
        this.setState({t2: event.target.value});
    }
    changet3Handler= (event) => {
        this.setState({t3: event.target.value});
    }
    changet4Handler= (event) => {
        this.setState({t4: event.target.value});
    }
    changet5Handler= (event) => {
        this.setState({t5: event.target.value});
    }
    changet6Handler= (event) => {
        this.setState({t6: event.target.value});
    }
    changet7Handler= (event) => {
        this.setState({t7: event.target.value});
    }
    changet8Handler= (event) => {
        this.setState({t8: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changetpHandler= (event) => {
        this.setState({tp: event.target.value});
    }
    changettHandler= (event) => {
        this.setState({tt: event.target.value});
    }
    changetwHandler= (event) => {
        this.setState({tw: event.target.value});
    }
    changevelclHandler= (event) => {
        this.setState({velcl: event.target.value});
    }
    changevelopHandler= (event) => {
        this.setState({velop: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroRs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroR</h3>
        }else{
            return <h3 className="text-center">Update GovHydroR</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> at: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> db2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dturb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> eps: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> gv6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> h0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> inputSignal: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pgv6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> qnl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t6: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t7: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t8: </label>
                                            #formFields( $attribute, 'create')
                                            <label> td: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tw: </label>
                                            #formFields( $attribute, 'create')
                                            <label> velcl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> velop: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroR}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                   </div>
            </div>
        )
    }
}

export default CreateGovHydroRComponent
