import React, { Component } from 'react'
import GovSteamFV3Service from '../services/GovSteamFV3Service';

class UpdateGovSteamFV3Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                k: '',
                k1: '',
                k2: '',
                k3: '',
                mwbase: '',
                pmax: '',
                pmin: '',
                prmax: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                t5: '',
                t6: '',
                ta: '',
                tb: '',
                tc: '',
                uc: '',
                uo: ''
        }
        this.updateGovSteamFV3 = this.updateGovSteamFV3.bind(this);

        this.changekHandler = this.changekHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changeprmaxHandler = this.changeprmaxHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changet5Handler = this.changet5Handler.bind(this);
        this.changet6Handler = this.changet6Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeucHandler = this.changeucHandler.bind(this);
        this.changeuoHandler = this.changeuoHandler.bind(this);
    }

    componentDidMount(){
        GovSteamFV3Service.getGovSteamFV3ById(this.state.id).then( (res) =>{
            let govSteamFV3 = res.data;
            this.setState({
                k: govSteamFV3.k,
                k1: govSteamFV3.k1,
                k2: govSteamFV3.k2,
                k3: govSteamFV3.k3,
                mwbase: govSteamFV3.mwbase,
                pmax: govSteamFV3.pmax,
                pmin: govSteamFV3.pmin,
                prmax: govSteamFV3.prmax,
                t1: govSteamFV3.t1,
                t2: govSteamFV3.t2,
                t3: govSteamFV3.t3,
                t4: govSteamFV3.t4,
                t5: govSteamFV3.t5,
                t6: govSteamFV3.t6,
                ta: govSteamFV3.ta,
                tb: govSteamFV3.tb,
                tc: govSteamFV3.tc,
                uc: govSteamFV3.uc,
                uo: govSteamFV3.uo
            });
        });
    }

    updateGovSteamFV3 = (e) => {
        e.preventDefault();
        let govSteamFV3 = {
            govSteamFV3Id: this.state.id,
            k: this.state.k,
            k1: this.state.k1,
            k2: this.state.k2,
            k3: this.state.k3,
            mwbase: this.state.mwbase,
            pmax: this.state.pmax,
            pmin: this.state.pmin,
            prmax: this.state.prmax,
            t1: this.state.t1,
            t2: this.state.t2,
            t3: this.state.t3,
            t4: this.state.t4,
            t5: this.state.t5,
            t6: this.state.t6,
            ta: this.state.ta,
            tb: this.state.tb,
            tc: this.state.tc,
            uc: this.state.uc,
            uo: this.state.uo
        };
        console.log('govSteamFV3 => ' + JSON.stringify(govSteamFV3));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteamFV3Service.updateGovSteamFV3(govSteamFV3).then( res => {
            this.props.history.push('/govSteamFV3s');
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
    changemwbaseHandler= (event) => {
        this.setState({mwbase: event.target.value});
    }
    changepmaxHandler= (event) => {
        this.setState({pmax: event.target.value});
    }
    changepminHandler= (event) => {
        this.setState({pmin: event.target.value});
    }
    changeprmaxHandler= (event) => {
        this.setState({prmax: event.target.value});
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
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changeucHandler= (event) => {
        this.setState({uc: event.target.value});
    }
    changeuoHandler= (event) => {
        this.setState({uo: event.target.value});
    }

    cancel(){
        this.props.history.push('/govSteamFV3s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteamFV3</h3>
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
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> prmax: </label>
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
                                            <label> ta: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uo: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteamFV3}>Save</button>
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

export default UpdateGovSteamFV3Component
