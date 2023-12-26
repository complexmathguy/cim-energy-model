import React, { Component } from 'react'
import GovSteam0Service from '../services/GovSteam0Service';

class CreateGovSteam0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                dt: '',
                mwbase: '',
                r: '',
                t1: '',
                t2: '',
                t3: '',
                vmax: '',
                vmin: ''
        }
        this.changedtHandler = this.changedtHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changerHandler = this.changerHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changevmaxHandler = this.changevmaxHandler.bind(this);
        this.changevminHandler = this.changevminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovSteam0Service.getGovSteam0ById(this.state.id).then( (res) =>{
                let govSteam0 = res.data;
                this.setState({
                    dt: govSteam0.dt,
                    mwbase: govSteam0.mwbase,
                    r: govSteam0.r,
                    t1: govSteam0.t1,
                    t2: govSteam0.t2,
                    t3: govSteam0.t3,
                    vmax: govSteam0.vmax,
                    vmin: govSteam0.vmin
                });
            });
        }        
    }
    saveOrUpdateGovSteam0 = (e) => {
        e.preventDefault();
        let govSteam0 = {
                govSteam0Id: this.state.id,
                dt: this.state.dt,
                mwbase: this.state.mwbase,
                r: this.state.r,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                vmax: this.state.vmax,
                vmin: this.state.vmin
            };
        console.log('govSteam0 => ' + JSON.stringify(govSteam0));

        // step 5
        if(this.state.id === '_add'){
            govSteam0.govSteam0Id=''
            GovSteam0Service.createGovSteam0(govSteam0).then(res =>{
                this.props.history.push('/govSteam0s');
            });
        }else{
            GovSteam0Service.updateGovSteam0(govSteam0).then( res => {
                this.props.history.push('/govSteam0s');
            });
        }
    }
    
    changedtHandler= (event) => {
        this.setState({dt: event.target.value});
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
    changet2Handler= (event) => {
        this.setState({t2: event.target.value});
    }
    changet3Handler= (event) => {
        this.setState({t3: event.target.value});
    }
    changevmaxHandler= (event) => {
        this.setState({vmax: event.target.value});
    }
    changevminHandler= (event) => {
        this.setState({vmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/govSteam0s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovSteam0</h3>
        }else{
            return <h3 className="text-center">Update GovSteam0</h3>
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
                                            <label> dt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'create')
                                            <label> r: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovSteam0}>Save</button>
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

export default CreateGovSteam0Component
