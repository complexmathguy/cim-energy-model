import React, { Component } from 'react'
import GovSteamFV2Service from '../services/GovSteamFV2Service';

class UpdateGovSteamFV2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dt: '',
                k: '',
                mwbase: '',
                r: '',
                t1: '',
                t3: '',
                ta: '',
                tb: '',
                tc: '',
                ti: '',
                tt: '',
                vmax: '',
                vmin: ''
        }
        this.updateGovSteamFV2 = this.updateGovSteamFV2.bind(this);

        this.changedtHandler = this.changedtHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetiHandler = this.changetiHandler.bind(this);
        this.changettHandler = this.changettHandler.bind(this);
        this.changevmaxHandler = this.changevmaxHandler.bind(this);
        this.changevminHandler = this.changevminHandler.bind(this);
    }

    componentDidMount(){
        GovSteamFV2Service.getGovSteamFV2ById(this.state.id).then( (res) =>{
            let govSteamFV2 = res.data;
            this.setState({
                dt: govSteamFV2.dt,
                k: govSteamFV2.k,
                mwbase: govSteamFV2.mwbase,
                r: govSteamFV2.r,
                t1: govSteamFV2.t1,
                t3: govSteamFV2.t3,
                ta: govSteamFV2.ta,
                tb: govSteamFV2.tb,
                tc: govSteamFV2.tc,
                ti: govSteamFV2.ti,
                tt: govSteamFV2.tt,
                vmax: govSteamFV2.vmax,
                vmin: govSteamFV2.vmin
            });
        });
    }

    updateGovSteamFV2 = (e) => {
        e.preventDefault();
        let govSteamFV2 = {
            govSteamFV2Id: this.state.id,
            dt: this.state.dt,
            k: this.state.k,
            mwbase: this.state.mwbase,
            r: this.state.r,
            t1: this.state.t1,
            t3: this.state.t3,
            ta: this.state.ta,
            tb: this.state.tb,
            tc: this.state.tc,
            ti: this.state.ti,
            tt: this.state.tt,
            vmax: this.state.vmax,
            vmin: this.state.vmin
        };
        console.log('govSteamFV2 => ' + JSON.stringify(govSteamFV2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamFV2Service.updateGovSteamFV2(govSteamFV2).then( res => {
            this.props.history.push('/govSteamFV2s');
        });
    }

    changedtHandler= (event) => {
        this.setState({dt: event.target.value});
    }
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changerHandler= (event) => {
        this.setState({r: event.target.value});
    }
    changet1Handler= (event) => {
        this.setState({t1: event.target.value});
    }
    changet3Handler= (event) => {
        this.setState({t3: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetiHandler= (event) => {
        this.setState({ti: event.target.value});
    }
    changettHandler= (event) => {
        this.setState({tt: event.target.value});
    }
    changevmaxHandler= (event) => {
        this.setState({vmax: event.target.value});
    }
    changevminHandler= (event) => {
        this.setState({vmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/govSteamFV2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamFV2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ti: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamFV2}>Save</button>
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

export default UpdateGovSteamFV2Component
