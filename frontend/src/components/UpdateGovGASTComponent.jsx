import React, { Component } from 'react'
import GovGASTService from '../services/GovGASTService';

class UpdateGovGASTComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
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
        this.updateGovGAST = this.updateGovGAST.bind(this);

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

    componentDidMount(){
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

    updateGovGAST = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        GovGASTService.updateGovGAST(govGAST).then( res => {
            this.props.history.push('/govGASTs');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GovGAST</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> at: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dturb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwbase: </label>
                                            #formFields( $attribute, 'update')
                                            <label> r: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> vmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGovGAST}>Save</button>
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

export default UpdateGovGASTComponent
