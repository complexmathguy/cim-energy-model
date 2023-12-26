import React, { Component } from 'react'
import GovSteam2Service from '../services/GovSteam2Service';

class UpdateGovSteam2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dbf: '',
                k: '',
                mnef: '',
                mxef: '',
                pmax: '',
                pmin: '',
                t1: '',
                t2: ''
        }
        this.updateGovSteam2 = this.updateGovSteam2.bind(this);

        this.changedbfHandler = this.changedbfHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changemnefHandler = this.changemnefHandler.bind(this);
        this.changemxefHandler = this.changemxefHandler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
    }

    componentDidMount(){
        GovSteam2Service.getGovSteam2ById(this.state.id).then( (res) =>{
            let govSteam2 = res.data;
            this.setState({
                dbf: govSteam2.dbf,
                k: govSteam2.k,
                mnef: govSteam2.mnef,
                mxef: govSteam2.mxef,
                pmax: govSteam2.pmax,
                pmin: govSteam2.pmin,
                t1: govSteam2.t1,
                t2: govSteam2.t2
            });
        });
    }

    updateGovSteam2 = (e) => {
        e.preventDefault();
        let govSteam2 = {
            govSteam2Id: this.state.id,
            dbf: this.state.dbf,
            k: this.state.k,
            mnef: this.state.mnef,
            mxef: this.state.mxef,
            pmax: this.state.pmax,
            pmin: this.state.pmin,
            t1: this.state.t1,
            t2: this.state.t2
        };
        console.log('govSteam2 => ' + JSON.stringify(govSteam2));
        console.log('id => ' + JSON.stringify(this.state.id));
        GovSteam2Service.updateGovSteam2(govSteam2).then( res => {
            this.props.history.push('/govSteam2s');
        });
    }

    changedbfHandler= (event) => {
        this.setState({dbf: event.target.value});
    }
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changemnefHandler= (event) => {
        this.setState({mnef: event.target.value});
    }
    changemxefHandler= (event) => {
        this.setState({mxef: event.target.value});
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

    cancel(){
        this.props.history.push('/govSteam2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovSteam2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dbf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mnef: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mxef: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovSteam2}>Save</button>
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

export default UpdateGovSteam2Component
