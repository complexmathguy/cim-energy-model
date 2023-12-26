import React, { Component } from 'react'
import GovHydroDDService from '../services/GovHydroDDService';

class UpdateGovHydroDDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                aturb: '',
                bturb: '',
                db1: '',
                db2: '',
                eps: '',
                gmax: '',
                gmin: '',
                gv1: '',
                gv2: '',
                gv3: '',
                gv4: '',
                gv5: '',
                gv6: '',
                inputSignal: '',
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
                r: '',
                td: '',
                tf: '',
                tp: '',
                tt: '',
                tturb: '',
                velcl: '',
                velop: ''
        }
        this.updateGovHydroDD = this.updateGovHydroDD.bind(this);

        this.changeaturbHandler = this.changeaturbHandler.bind(this);
        this.changebturbHandler = this.changebturbHandler.bind(this);
        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changedb2Handler = this.changedb2Handler.bind(this);
        this.changeepsHandler = this.changeepsHandler.bind(this);
        this.changegmaxHandler = this.changegmaxHandler.bind(this);
        this.changegminHandler = this.changegminHandler.bind(this);
        this.changegv1Handler = this.changegv1Handler.bind(this);
        this.changegv2Handler = this.changegv2Handler.bind(this);
        this.changegv3Handler = this.changegv3Handler.bind(this);
        this.changegv4Handler = this.changegv4Handler.bind(this);
        this.changegv5Handler = this.changegv5Handler.bind(this);
        this.changegv6Handler = this.changegv6Handler.bind(this);
        this.changeinputSignalHandler = this.changeinputSignalHandler.bind(this);
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
        this.changerHandler = this.changerHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changetpHandler = this.changetpHandler.bind(this);
        this.changettHandler = this.changettHandler.bind(this);
        this.changetturbHandler = this.changetturbHandler.bind(this);
        this.changevelclHandler = this.changevelclHandler.bind(this);
        this.changevelopHandler = this.changevelopHandler.bind(this);
    }

    componentDidMount(){
        GovHydroDDService.getGovHydroDDById(this.state.id).then( (res) =>{
            let govHydroDD = res.data;
            this.setState({
                aturb: govHydroDD.aturb,
                bturb: govHydroDD.bturb,
                db1: govHydroDD.db1,
                db2: govHydroDD.db2,
                eps: govHydroDD.eps,
                gmax: govHydroDD.gmax,
                gmin: govHydroDD.gmin,
                gv1: govHydroDD.gv1,
                gv2: govHydroDD.gv2,
                gv3: govHydroDD.gv3,
                gv4: govHydroDD.gv4,
                gv5: govHydroDD.gv5,
                gv6: govHydroDD.gv6,
                inputSignal: govHydroDD.inputSignal,
                k1: govHydroDD.k1,
                k2: govHydroDD.k2,
                kg: govHydroDD.kg,
                ki: govHydroDD.ki,
                mwbase: govHydroDD.mwbase,
                pgv1: govHydroDD.pgv1,
                pgv2: govHydroDD.pgv2,
                pgv3: govHydroDD.pgv3,
                pgv4: govHydroDD.pgv4,
                pgv5: govHydroDD.pgv5,
                pgv6: govHydroDD.pgv6,
                pmax: govHydroDD.pmax,
                pmin: govHydroDD.pmin,
                r: govHydroDD.r,
                td: govHydroDD.td,
                tf: govHydroDD.tf,
                tp: govHydroDD.tp,
                tt: govHydroDD.tt,
                tturb: govHydroDD.tturb,
                velcl: govHydroDD.velcl,
                velop: govHydroDD.velop
            });
        });
    }

    updateGovHydroDD = (e) => {
        e.preventDefault();
        let govHydroDD = {
            govHydroDDId: this.state.id,
            aturb: this.state.aturb,
            bturb: this.state.bturb,
            db1: this.state.db1,
            db2: this.state.db2,
            eps: this.state.eps,
            gmax: this.state.gmax,
            gmin: this.state.gmin,
            gv1: this.state.gv1,
            gv2: this.state.gv2,
            gv3: this.state.gv3,
            gv4: this.state.gv4,
            gv5: this.state.gv5,
            gv6: this.state.gv6,
            inputSignal: this.state.inputSignal,
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
            r: this.state.r,
            td: this.state.td,
            tf: this.state.tf,
            tp: this.state.tp,
            tt: this.state.tt,
            tturb: this.state.tturb,
            velcl: this.state.velcl,
            velop: this.state.velop
        };
        console.log('govHydroDD => ' + JSON.stringify(govHydroDD));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroDDService.updateGovHydroDD(govHydroDD).then( res => {
            this.props.history.push('/govHydroDDs');
        });
    }

    changeaturbHandler= (event) => {
        this.setState({aturb: event.target.value});
    }
    changebturbHandler= (event) => {
        this.setState({bturb: event.target.value});
    }
    changedb1Handler= (event) => {
        this.setState({db1: event.target.value});
    }
    changedb2Handler= (event) => {
        this.setState({db2: event.target.value});
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
    changeinputSignalHandler= (event) => {
        this.setState({inputSignal: event.target.value});
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
    changerHandler= (event) => {
        this.setState({r: event.target.value});
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
    changetturbHandler= (event) => {
        this.setState({tturb: event.target.value});
    }
    changevelclHandler= (event) => {
        this.setState({velcl: event.target.value});
    }
    changevelopHandler= (event) => {
        this.setState({velop: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroDDs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroDD</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> aturb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bturb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> db1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> db2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> eps: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> gv6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> inputSignal: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pgv6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> td: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tturb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> velcl: </label>
                                            #formFields( $attribute, 'update')
                                            <label> velop: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroDD}>Save</button>
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

export default UpdateGovHydroDDComponent
