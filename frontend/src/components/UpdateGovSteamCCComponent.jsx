import React, { Component } from 'react'
import GovSteamCCService from '../services/GovSteamCCService';

class UpdateGovSteamCCComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dhp: '',
                dlp: '',
                fhp: '',
                flp: '',
                mwbase: '',
                pmaxhp: '',
                pmaxlp: '',
                rhp: '',
                rlp: '',
                t1hp: '',
                t1lp: '',
                t3hp: '',
                t3lp: '',
                t4hp: '',
                t4lp: '',
                t5hp: '',
                t5lp: ''
        }
        this.updateGovSteamCC = this.updateGovSteamCC.bind(this);

        this.changedhpHandler = this.changedhpHandler.bind(this);
        this.changedlpHandler = this.changedlpHandler.bind(this);
        this.changefhpHandler = this.changefhpHandler.bind(this);
        this.changeflpHandler = this.changeflpHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepmaxhpHandler = this.changepmaxhpHandler.bind(this);
        this.changepmaxlpHandler = this.changepmaxlpHandler.bind(this);
        this.changerhpHandler = this.changerhpHandler.bind(this);
        this.changerlpHandler = this.changerlpHandler.bind(this);
        this.changet1hpHandler = this.changet1hpHandler.bind(this);
        this.changet1lpHandler = this.changet1lpHandler.bind(this);
        this.changet3hpHandler = this.changet3hpHandler.bind(this);
        this.changet3lpHandler = this.changet3lpHandler.bind(this);
        this.changet4hpHandler = this.changet4hpHandler.bind(this);
        this.changet4lpHandler = this.changet4lpHandler.bind(this);
        this.changet5hpHandler = this.changet5hpHandler.bind(this);
        this.changet5lpHandler = this.changet5lpHandler.bind(this);
    }

    componentDidMount(){
        GovSteamCCService.getGovSteamCCById(this.state.id).then( (res) =>{
            let govSteamCC = res.data;
            this.setState({
                dhp: govSteamCC.dhp,
                dlp: govSteamCC.dlp,
                fhp: govSteamCC.fhp,
                flp: govSteamCC.flp,
                mwbase: govSteamCC.mwbase,
                pmaxhp: govSteamCC.pmaxhp,
                pmaxlp: govSteamCC.pmaxlp,
                rhp: govSteamCC.rhp,
                rlp: govSteamCC.rlp,
                t1hp: govSteamCC.t1hp,
                t1lp: govSteamCC.t1lp,
                t3hp: govSteamCC.t3hp,
                t3lp: govSteamCC.t3lp,
                t4hp: govSteamCC.t4hp,
                t4lp: govSteamCC.t4lp,
                t5hp: govSteamCC.t5hp,
                t5lp: govSteamCC.t5lp
            });
        });
    }

    updateGovSteamCC = (e) => {
        e.preventDefault();
        let govSteamCC = {
            govSteamCCId: this.state.id,
            dhp: this.state.dhp,
            dlp: this.state.dlp,
            fhp: this.state.fhp,
            flp: this.state.flp,
            mwbase: this.state.mwbase,
            pmaxhp: this.state.pmaxhp,
            pmaxlp: this.state.pmaxlp,
            rhp: this.state.rhp,
            rlp: this.state.rlp,
            t1hp: this.state.t1hp,
            t1lp: this.state.t1lp,
            t3hp: this.state.t3hp,
            t3lp: this.state.t3lp,
            t4hp: this.state.t4hp,
            t4lp: this.state.t4lp,
            t5hp: this.state.t5hp,
            t5lp: this.state.t5lp
        };
        console.log('govSteamCC => ' + JSON.stringify(govSteamCC));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamCCService.updateGovSteamCC(govSteamCC).then( res => {
            this.props.history.push('/govSteamCCs');
        });
    }

    changedhpHandler= (event) => {
        this.setState({dhp: event.target.value});
    }
    changedlpHandler= (event) => {
        this.setState({dlp: event.target.value});
    }
    changefhpHandler= (event) => {
        this.setState({fhp: event.target.value});
    }
    changeflpHandler= (event) => {
        this.setState({flp: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepmaxhpHandler= (event) => {
        this.setState({pmaxhp: event.target.value});
    }
    changepmaxlpHandler= (event) => {
        this.setState({pmaxlp: event.target.value});
    }
    changerhpHandler= (event) => {
        this.setState({rhp: event.target.value});
    }
    changerlpHandler= (event) => {
        this.setState({rlp: event.target.value});
    }
    changet1hpHandler= (event) => {
        this.setState({t1hp: event.target.value});
    }
    changet1lpHandler= (event) => {
        this.setState({t1lp: event.target.value});
    }
    changet3hpHandler= (event) => {
        this.setState({t3hp: event.target.value});
    }
    changet3lpHandler= (event) => {
        this.setState({t3lp: event.target.value});
    }
    changet4hpHandler= (event) => {
        this.setState({t4hp: event.target.value});
    }
    changet4lpHandler= (event) => {
        this.setState({t4lp: event.target.value});
    }
    changet5hpHandler= (event) => {
        this.setState({t5hp: event.target.value});
    }
    changet5lpHandler= (event) => {
        this.setState({t5lp: event.target.value});
    }

    cancel(){
        this.props.history.push('/govSteamCCs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamCC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dhp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dlp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> fhp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> flp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmaxhp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmaxlp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rhp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rlp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1hp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1lp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3hp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3lp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4hp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4lp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t5hp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t5lp: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamCC}>Save</button>
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

export default UpdateGovSteamCCComponent
