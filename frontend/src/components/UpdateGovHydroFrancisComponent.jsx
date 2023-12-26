import React, { Component } from 'react'
import GovHydroFrancisService from '../services/GovHydroFrancisService';

class UpdateGovHydroFrancisComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                am: '',
                av0: '',
                av1: '',
                bp: '',
                db1: '',
                etamax: '',
                governorControl: '',
                h1: '',
                h2: '',
                hn: '',
                kc: '',
                kg: '',
                kt: '',
                qc0: '',
                qn: '',
                ta: '',
                td: '',
                ts: '',
                twnc: '',
                twng: '',
                tx: '',
                va: '',
                valvmax: '',
                valvmin: '',
                vc: '',
                waterTunnelSurgeChamberSimulation: '',
                zsfc: ''
        }
        this.updateGovHydroFrancis = this.updateGovHydroFrancis.bind(this);

        this.changeamHandler = this.changeamHandler.bind(this);
        this.changeav0Handler = this.changeav0Handler.bind(this);
        this.changeav1Handler = this.changeav1Handler.bind(this);
        this.changebpHandler = this.changebpHandler.bind(this);
        this.changedb1Handler = this.changedb1Handler.bind(this);
        this.changeetamaxHandler = this.changeetamaxHandler.bind(this);
        this.changegovernorControlHandler = this.changegovernorControlHandler.bind(this);
        this.changeh1Handler = this.changeh1Handler.bind(this);
        this.changeh2Handler = this.changeh2Handler.bind(this);
        this.changehnHandler = this.changehnHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changektHandler = this.changektHandler.bind(this);
        this.changeqc0Handler = this.changeqc0Handler.bind(this);
        this.changeqnHandler = this.changeqnHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changetsHandler = this.changetsHandler.bind(this);
        this.changetwncHandler = this.changetwncHandler.bind(this);
        this.changetwngHandler = this.changetwngHandler.bind(this);
        this.changetxHandler = this.changetxHandler.bind(this);
        this.changevaHandler = this.changevaHandler.bind(this);
        this.changevalvmaxHandler = this.changevalvmaxHandler.bind(this);
        this.changevalvminHandler = this.changevalvminHandler.bind(this);
        this.changevcHandler = this.changevcHandler.bind(this);
        this.changewaterTunnelSurgeChamberSimulationHandler = this.changewaterTunnelSurgeChamberSimulationHandler.bind(this);
        this.changezsfcHandler = this.changezsfcHandler.bind(this);
    }

    componentDidMount(){
        GovHydroFrancisService.getGovHydroFrancisById(this.state.id).then( (res) =>{
            let govHydroFrancis = res.data;
            this.setState({
                am: govHydroFrancis.am,
                av0: govHydroFrancis.av0,
                av1: govHydroFrancis.av1,
                bp: govHydroFrancis.bp,
                db1: govHydroFrancis.db1,
                etamax: govHydroFrancis.etamax,
                governorControl: govHydroFrancis.governorControl,
                h1: govHydroFrancis.h1,
                h2: govHydroFrancis.h2,
                hn: govHydroFrancis.hn,
                kc: govHydroFrancis.kc,
                kg: govHydroFrancis.kg,
                kt: govHydroFrancis.kt,
                qc0: govHydroFrancis.qc0,
                qn: govHydroFrancis.qn,
                ta: govHydroFrancis.ta,
                td: govHydroFrancis.td,
                ts: govHydroFrancis.ts,
                twnc: govHydroFrancis.twnc,
                twng: govHydroFrancis.twng,
                tx: govHydroFrancis.tx,
                va: govHydroFrancis.va,
                valvmax: govHydroFrancis.valvmax,
                valvmin: govHydroFrancis.valvmin,
                vc: govHydroFrancis.vc,
                waterTunnelSurgeChamberSimulation: govHydroFrancis.waterTunnelSurgeChamberSimulation,
                zsfc: govHydroFrancis.zsfc
            });
        });
    }

    updateGovHydroFrancis = (e) => {
        e.preventDefault();
        let govHydroFrancis = {
            govHydroFrancisId: this.state.id,
            am: this.state.am,
            av0: this.state.av0,
            av1: this.state.av1,
            bp: this.state.bp,
            db1: this.state.db1,
            etamax: this.state.etamax,
            governorControl: this.state.governorControl,
            h1: this.state.h1,
            h2: this.state.h2,
            hn: this.state.hn,
            kc: this.state.kc,
            kg: this.state.kg,
            kt: this.state.kt,
            qc0: this.state.qc0,
            qn: this.state.qn,
            ta: this.state.ta,
            td: this.state.td,
            ts: this.state.ts,
            twnc: this.state.twnc,
            twng: this.state.twng,
            tx: this.state.tx,
            va: this.state.va,
            valvmax: this.state.valvmax,
            valvmin: this.state.valvmin,
            vc: this.state.vc,
            waterTunnelSurgeChamberSimulation: this.state.waterTunnelSurgeChamberSimulation,
            zsfc: this.state.zsfc
        };
        console.log('govHydroFrancis => ' + JSON.stringify(govHydroFrancis));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovHydroFrancisService.updateGovHydroFrancis(govHydroFrancis).then( res => {
            this.props.history.push('/govHydroFranciss');
        });
    }

    changeamHandler= (event) => {
        this.setState({am: event.target.value});
    }
    changeav0Handler= (event) => {
        this.setState({av0: event.target.value});
    }
    changeav1Handler= (event) => {
        this.setState({av1: event.target.value});
    }
    changebpHandler= (event) => {
        this.setState({bp: event.target.value});
    }
    changedb1Handler= (event) => {
        this.setState({db1: event.target.value});
    }
    changeetamaxHandler= (event) => {
        this.setState({etamax: event.target.value});
    }
    changegovernorControlHandler= (event) => {
        this.setState({governorControl: event.target.value});
    }
    changeh1Handler= (event) => {
        this.setState({h1: event.target.value});
    }
    changeh2Handler= (event) => {
        this.setState({h2: event.target.value});
    }
    changehnHandler= (event) => {
        this.setState({hn: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekgHandler= (event) => {
        this.setState({kg: event.target.value});
    }
    changektHandler= (event) => {
        this.setState({kt: event.target.value});
    }
    changeqc0Handler= (event) => {
        this.setState({qc0: event.target.value});
    }
    changeqnHandler= (event) => {
        this.setState({qn: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changetsHandler= (event) => {
        this.setState({ts: event.target.value});
    }
    changetwncHandler= (event) => {
        this.setState({twnc: event.target.value});
    }
    changetwngHandler= (event) => {
        this.setState({twng: event.target.value});
    }
    changetxHandler= (event) => {
        this.setState({tx: event.target.value});
    }
    changevaHandler= (event) => {
        this.setState({va: event.target.value});
    }
    changevalvmaxHandler= (event) => {
        this.setState({valvmax: event.target.value});
    }
    changevalvminHandler= (event) => {
        this.setState({valvmin: event.target.value});
    }
    changevcHandler= (event) => {
        this.setState({vc: event.target.value});
    }
    changewaterTunnelSurgeChamberSimulationHandler= (event) => {
        this.setState({waterTunnelSurgeChamberSimulation: event.target.value});
    }
    changezsfcHandler= (event) => {
        this.setState({zsfc: event.target.value});
    }

    cancel(){
        this.props.history.push('/govHydroFranciss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovHydroFrancis</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> am: </label>
                                            #formFields( $attribute, 'update')
                                            <label> av0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> av1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> bp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> db1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> etamax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> governorControl: </label>
                                            #formFields( $attribute, 'update')
                                            <label> h1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> h2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> hn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qc0: </label>
                                            #formFields( $attribute, 'update')
                                            <label> qn: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> td: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts: </label>
                                            #formFields( $attribute, 'update')
                                            <label> twnc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> twng: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> va: </label>
                                            #formFields( $attribute, 'update')
                                            <label> valvmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> valvmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> waterTunnelSurgeChamberSimulation: </label>
                                            #formFields( $attribute, 'update')
                                            <label> zsfc: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovHydroFrancis}>Save</button>
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

export default UpdateGovHydroFrancisComponent
