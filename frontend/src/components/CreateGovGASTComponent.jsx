import React, { Component } from 'react'
import GovGASTService from '../services/GovGASTService';

class CreateGovGASTComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                at: '',
                dturb: '',
                kt: '',
                mwbase: '',
                r: '',
                t1: '',
                t2: '',
                t3: '',
                vmax: '',
                vmin: ''
        }
        this.changeatHandler = this.changeatHandler.bind(this);
        this.changedturbHandler = this.changedturbHandler.bind(this);
        this.changektHandler = this.changektHandler.bind(this);
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
            GovGASTService.getGovGASTById(this.state.id).then( (res) =>{
                let govGAST = res.data;
                this.setState({
                    at: govGAST.at,
                    dturb: govGAST.dturb,
                    kt: govGAST.kt,
                    mwbase: govGAST.mwbase,
                    r: govGAST.r,
                    t1: govGAST.t1,
                    t2: govGAST.t2,
                    t3: govGAST.t3,
                    vmax: govGAST.vmax,
                    vmin: govGAST.vmin
                });
            });
        }        
    }
    saveOrUpdateGovGAST = (e) => {
        e.preventDefault();
        let govGAST = {
                govGASTId: this.state.id,
                at: this.state.at,
                dturb: this.state.dturb,
                kt: this.state.kt,
                mwbase: this.state.mwbase,
                r: this.state.r,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                vmax: this.state.vmax,
                vmin: this.state.vmin
            };
        console.log('govGAST => ' + JSON.stringify(govGAST));

        // step 5
        if(this.state.id === '_add'){
            govGAST.govGASTId=''
            GovGASTService.createGovGAST(govGAST).then(res =>{
                this.props.history.push('/govGASTs');
            });
        }else{
            GovGASTService.updateGovGAST(govGAST).then( res => {
                this.props.history.push('/govGASTs');
            });
        }
    }
    
    changeatHandler= (event) => {
        this.setState({at: event.target.value});
    }
    changedturbHandler= (event) => {
        this.setState({dturb: event.target.value});
    }
    changektHandler= (event) => {
        this.setState({kt: event.target.value});
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
        this.props.history.push('/govGASTs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add GovGAST</h3>
        }else{
            return <h3 className="text-center">Update GovGAST</h3>
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
                                            <label> at: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dturb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kt: </label>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateGovGAST}>Save</button>
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

export default CreateGovGASTComponent
