import React, { Component } from 'react'
import GovSteamSGOService from '../services/GovSteamSGOService';

class UpdateGovSteamSGOComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                k1: '',
                k2: '',
                k3: '',
                mwbase: '',
                pmax: '',
                pmin: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: ''
        }
        this.updateGovSteamSGO = this.updateGovSteamSGO.bind(this);

        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
    }

    componentDidMount(){
        GovSteamSGOService.getGovSteamSGOById(this.state.id).then( (res) =>{
            let govSteamSGO = res.data;
            this.setState({
                k1: govSteamSGO.k1,
                k2: govSteamSGO.k2,
                k3: govSteamSGO.k3,
                mwbase: govSteamSGO.mwbase,
                pmax: govSteamSGO.pmax,
                pmin: govSteamSGO.pmin,
                t1: govSteamSGO.t1,
                t2: govSteamSGO.t2,
                t3: govSteamSGO.t3,
                t4: govSteamSGO.t4,
                t5: govSteamSGO.t5,
                t6: govSteamSGO.t6
            });
        });
    }

    updateGovSteamSGO = (e) => {
        e.preventDefault();
        let govSteamSGO = {
            govSteamSGOId: this.state.id,
            k1: this.state.k1,
            k2: this.state.k2,
            k3: this.state.k3,
            mwbase: this.state.mwbase,
            pmax: this.state.pmax,
            pmin: this.state.pmin,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            t6: this.state.t6
        };
        console.log('govSteamSGO => ' + JSON.stringify(govSteamSGO));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamSGOService.updateGovSteamSGO(govSteamSGO).then( res => {
            this.props.history.push('/govSteamSGOs');
        });
    }

    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changek2Handler= (event) => {
        this.setState({k2: event.target.value});
    }
    changek3Handler= (event) => {
        this.setState({k3: event.target.value});
    }
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepmaxHandler= (event) => {
        this.setState({pmax: event.target.value});
    }
    changepminHandler= (event) => {
        this.setState({pmin: event.target.value});
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

    cancel(){
        this.props.history.push('/govSteamSGOs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamSGO</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> k1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t6: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamSGO}>Save</button>
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

export default UpdateGovSteamSGOComponent
