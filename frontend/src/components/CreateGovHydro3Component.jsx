import React, { Component } from 'react'
import GovHydro3Service from '../services/GovHydro3Service';

class CreateGovHydro3Component extends Component {
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
                governorControl: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                gv6: '',
                h0: '',
                k1: '',
                k2: '',
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
                relec: '',
                rgate: '',
                td: '',
                tf: '',
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
        this.changegovernorControlHandler = this.changegovernorControlHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changegv6Handler = this.changegv6Handler.bind(this);
        this.changeh0Handler = this.changeh0Handler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
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
        this.changerelecHandler = this.changerelecHandler.bind(this);
        this.changergateHandler = this.changergateHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
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
            GovHydro3Service.getGovHydro3ById(this.state.id).then( (res) =>{
                let govHydro3 = res.data;
                this.setState({
                    at: govHydro3.at,
                    db1: govHydro3.db1,
                    db2: govHydro3.db2,
                    dturb: govHydro3.dturb,
                    eps: govHydro3.eps,
                    governorControl: govHydro3.governorControl,
                    gv1: govHydro3.gv1,
                    gv2: govHydro3.gv2,
                    gv3: govHydro3.gv3,
                    gv4: govHydro3.gv4,
                    gv5: govHydro3.gv5,
                    gv6: govHydro3.gv6,
                    h0: govHydro3.h0,
                    k1: govHydro3.k1,
                    k2: govHydro3.k2,
                    kg: govHydro3.kg,
                    ki: govHydro3.ki,
                    mwbase: govHydro3.mwbase,
                    pgv1: govHydro3.pgv1,
                    pgv2: govHydro3.pgv2,
                    pgv3: govHydro3.pgv3,
                    pgv4: govHydro3.pgv4,
                    pgv5: govHydro3.pgv5,
                    pgv6: govHydro3.pgv6,
                    pmax: govHydro3.pmax,
                    pmin: govHydro3.pmin,
                    qnl: govHydro3.qnl,
                    relec: govHydro3.relec,
                    rgate: govHydro3.rgate,
                    td: govHydro3.td,
                    tf: govHydro3.tf,
                    tp: govHydro3.tp,
                    tt: govHydro3.tt,
                    tw: govHydro3.tw,
                    velcl: govHydro3.velcl,
                    velop: govHydro3.velop
                });
            });
        }        
    }
    saveOrUpdateGovHydro3 = (e) => {
        e.preventDefault();
        let govHydro3 = {
                govHydro3Id: this.state.id,
                at: this.state.at,
                db1: this.state.db1,
                db2: this.state.db2,
                dturb: this.state.dturb,
                eps: this.state.eps,
                governorControl: this.state.governorControl,
                gv1: this.state.gv1,
                gv2: this.state.gv2,
                gv3: this.state.gv3,
                gv4: this.state.gv4,
                gv5: this.state.gv5,
                gv6: this.state.gv6,
                h0: this.state.h0,
                k1: this.state.k1,
                k2: this.state.k2,
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
                relec: this.state.relec,
                rgate: this.state.rgate,
                td: this.state.td,
                tf: this.state.tf,
                tp: this.state.tp,
                tt: this.state.tt,
                tw: this.state.tw,
                velcl: this.state.velcl,
                velop: this.state.velop
            };
        console.log('govHydro3 => ' + JSON.stringify(govHydro3));

        // step 5
        if(this.state.id === '_add'){
            govHydro3.govHydro3Id=''
            GovHydro3Service.createGovHydro3(govHydro3).then(res =>{
                this.props.history.push('/govHydro3s');
            });
        }else{
            GovHydro3Service.updateGovHydro3(govHydro3).then( res => {
                this.props.history.push('/govHydro3s');
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
    changegovernorControlHandler= (event) => {
        this.setState({governorControl: event.target.value});
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
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
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
    changerelecHandler= (event) => {
        this.setState({relec: event.target.value});
    }
    changergateHandler= (event) => {
        this.setState({rgate: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
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
        this.props.history.push('/govHydro3s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydro3</h3>
        }else{
            return <h3 className="text-center">Update GovHydro3</h3>
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
                                            <label> governorControl: </label>
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
                                            <label> k1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k2: </label>
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
                                            <label> relec: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rgate: </label>
                                            #formFields( $attribute, 'create')
                                            <label> td: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydro3}>Save</button>
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

export default CreateGovHydro3Component
