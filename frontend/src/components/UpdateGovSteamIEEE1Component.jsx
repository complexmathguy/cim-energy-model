import React, { Component } from 'react'
import GovSteamIEEE1Service from '../services/GovSteamIEEE1Service';

class UpdateGovSteamIEEE1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                k: '',
                k1: '',
                k2: '',
                k3: '',
                k4: '',
                k5: '',
                k6: '',
                k7: '',
                k8: '',
                mwbase: '',
                pmax: '',
                pmin: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                t7: '',
                uc: '',
                uo: ''
        }
        this.updateGovSteamIEEE1 = this.updateGovSteamIEEE1.bind(this);

        this.changekHandler = this.changekHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changek4Handler = this.changek4Handler.bind(this);
        this.changek5Handler = this.changek5Handler.bind(this);
        this.changek6Handler = this.changek6Handler.bind(this);
        this.changek7Handler = this.changek7Handler.bind(this);
        this.changek8Handler = this.changek8Handler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changet7Handler = this.changet7Handler.bind(this);
        this.changeucHandler = this.changeucHandler.bind(this);
        this.changeuoHandler = this.changeuoHandler.bind(this);
    }

    componentDidMount(){
        GovSteamIEEE1Service.getGovSteamIEEE1ById(this.state.id).then( (res) =>{
            let govSteamIEEE1 = res.data;
            this.setState({
                k: govSteamIEEE1.k,
                k1: govSteamIEEE1.k1,
                k2: govSteamIEEE1.k2,
                k3: govSteamIEEE1.k3,
                k4: govSteamIEEE1.k4,
                k5: govSteamIEEE1.k5,
                k6: govSteamIEEE1.k6,
                k7: govSteamIEEE1.k7,
                k8: govSteamIEEE1.k8,
                mwbase: govSteamIEEE1.mwbase,
                pmax: govSteamIEEE1.pmax,
                pmin: govSteamIEEE1.pmin,
                t1: govSteamIEEE1.t1,
                t2: govSteamIEEE1.t2,
                t3: govSteamIEEE1.t3,
                t4: govSteamIEEE1.t4,
                t5: govSteamIEEE1.t5,
                t6: govSteamIEEE1.t6,
                t7: govSteamIEEE1.t7,
                uc: govSteamIEEE1.uc,
                uo: govSteamIEEE1.uo
            });
        });
    }

    updateGovSteamIEEE1 = (e) => {
        e.preventDefault();
        let govSteamIEEE1 = {
            govSteamIEEE1Id: this.state.id,
            k: this.state.k,
            k1: this.state.k1,
            k2: this.state.k2,
            k3: this.state.k3,
            k4: this.state.k4,
            k5: this.state.k5,
            k6: this.state.k6,
            k7: this.state.k7,
            k8: this.state.k8,
            mwbase: this.state.mwbase,
            pmax: this.state.pmax,
            pmin: this.state.pmin,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            t6: this.state.t6,
            t7: this.state.t7,
            uc: this.state.uc,
            uo: this.state.uo
        };
        console.log('govSteamIEEE1 => ' + JSON.stringify(govSteamIEEE1));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamIEEE1Service.updateGovSteamIEEE1(govSteamIEEE1).then( res => {
            this.props.history.push('/govSteamIEEE1s');
        });
    }

    changekHandler= (event) => {
        this.setState({k: event.target.value});
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
    changek4Handler= (event) => {
        this.setState({k4: event.target.value});
    }
    changek5Handler= (event) => {
        this.setState({k5: event.target.value});
    }
    changek6Handler= (event) => {
        this.setState({k6: event.target.value});
    }
    changek7Handler= (event) => {
        this.setState({k7: event.target.value});
    }
    changek8Handler= (event) => {
        this.setState({k8: event.target.value});
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
    changet7Handler= (event) => {
        this.setState({t7: event.target.value});
    }
    changeucHandler= (event) => {
        this.setState({uc: event.target.value});
    }
    changeuoHandler= (event) => {
        this.setState({uo: event.target.value});
    }

    cancel(){
        this.props.history.push('/govSteamIEEE1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamIEEE1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> k: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k6: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k7: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k8: </label>
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
                                            <label> t7: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uo: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamIEEE1}>Save</button>
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

export default UpdateGovSteamIEEE1Component
