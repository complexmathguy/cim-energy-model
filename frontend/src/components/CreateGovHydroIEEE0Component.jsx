import React, { Component } from 'react'
import GovHydroIEEE0Service from '../services/GovHydroIEEE0Service';

class CreateGovHydroIEEE0Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                k: '',
                mwbase: '',
                pmax: '',
                pmin: '',
                t1: '',
                t2: '',
                t3: '',
                t4: ''
        }
        this.changekHandler = this.changekHandler.bind(this);
        this.changemwbaseHandler = this.changemwbaseHandler.bind(this);
        this.changepmaxHandler = this.changepmaxHandler.bind(this);
        this.changepminHandler = this.changepminHandler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            GovHydroIEEE0Service.getGovHydroIEEE0ById(this.state.id).then( (res) =>{
                let govHydroIEEE0 = res.data;
                this.setState({
                    k: govHydroIEEE0.k,
                    mwbase: govHydroIEEE0.mwbase,
                    pmax: govHydroIEEE0.pmax,
                    pmin: govHydroIEEE0.pmin,
                    t1: govHydroIEEE0.t1,
                    t2: govHydroIEEE0.t2,
                    t3: govHydroIEEE0.t3,
                    t4: govHydroIEEE0.t4
                });
            });
        }        
    }
    saveOrUpdateGovHydroIEEE0 = (e) => {
        e.preventDefault();
        let govHydroIEEE0 = {
                govHydroIEEE0Id: this.state.id,
                k: this.state.k,
                mwbase: this.state.mwbase,
                pmax: this.state.pmax,
                pmin: this.state.pmin,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4
            };
        console.log('govHydroIEEE0 => ' + JSON.stringify(govHydroIEEE0));

        // step 5
        if(this.state.id === '_add'){
            govHydroIEEE0.govHydroIEEE0Id=''
            GovHydroIEEE0Service.createGovHydroIEEE0(govHydroIEEE0).then(res =>{
                this.props.history.push('/govHydroIEEE0s');
            });
        }else{
            GovHydroIEEE0Service.updateGovHydroIEEE0(govHydroIEEE0).then( res => {
                this.props.history.push('/govHydroIEEE0s');
            });
        }
    }
    
    changekHandler= (event) => {
        this.setState({k: event.target.value});
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

    cancel(){
        this.props.history.push('/govHydroIEEE0s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovHydroIEEE0</h3>
        }else{
            return <h3 className="text-center">Update GovHydroIEEE0</h3>
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
                                            <label> k: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovHydroIEEE0}>Save</button>
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

export default CreateGovHydroIEEE0Component
