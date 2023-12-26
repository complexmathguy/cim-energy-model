import React, { Component } from 'react'
import PssSHService from '../services/PssSHService';

class CreatePssSHComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                k: '',
                k0: '',
                k1: '',
                k2: '',
                k3: '',
                k4: '',
                t1: '',
                t2: '',
                t3: '',
                t4: '',
                td: '',
                vsmax: '',
                vsmin: ''
        }
        this.changekHandler = this.changekHandler.bind(this);
        this.changek0Handler = this.changek0Handler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changek2Handler = this.changek2Handler.bind(this);
        this.changek3Handler = this.changek3Handler.bind(this);
        this.changek4Handler = this.changek4Handler.bind(this);
        this.changet1Handler = this.changet1Handler.bind(this);
        this.changet2Handler = this.changet2Handler.bind(this);
        this.changet3Handler = this.changet3Handler.bind(this);
        this.changet4Handler = this.changet4Handler.bind(this);
        this.changetdHandler = this.changetdHandler.bind(this);
        this.changevsmaxHandler = this.changevsmaxHandler.bind(this);
        this.changevsminHandler = this.changevsminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PssSHService.getPssSHById(this.state.id).then( (res) =>{
                let pssSH = res.data;
                this.setState({
                    k: pssSH.k,
                    k0: pssSH.k0,
                    k1: pssSH.k1,
                    k2: pssSH.k2,
                    k3: pssSH.k3,
                    k4: pssSH.k4,
                    t1: pssSH.t1,
                    t2: pssSH.t2,
                    t3: pssSH.t3,
                    t4: pssSH.t4,
                    td: pssSH.td,
                    vsmax: pssSH.vsmax,
                    vsmin: pssSH.vsmin
                });
            });
        }        
    }
    saveOrUpdatePssSH = (e) => {
        e.preventDefault();
        let pssSH = {
                pssSHId: this.state.id,
                k: this.state.k,
                k0: this.state.k0,
                k1: this.state.k1,
                k2: this.state.k2,
                k3: this.state.k3,
                k4: this.state.k4,
                t1: this.state.t1,
                t2: this.state.t2,
                t3: this.state.t3,
                t4: this.state.t4,
                td: this.state.td,
                vsmax: this.state.vsmax,
                vsmin: this.state.vsmin
            };
        console.log('pssSH => ' + JSON.stringify(pssSH));

        // step 5
        if(this.state.id === '_add'){
            pssSH.pssSHId=''
            PssSHService.createPssSH(pssSH).then(res =>{
                this.props.history.push('/pssSHs');
            });
        }else{
            PssSHService.updatePssSH(pssSH).then( res => {
                this.props.history.push('/pssSHs');
            });
        }
    }
    
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changek0Handler= (event) => {
        this.setState({k0: event.target.value});
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
    changetdHandler= (event) => {
        this.setState({td: event.target.value});
    }
    changevsmaxHandler= (event) => {
        this.setState({vsmax: event.target.value});
    }
    changevsminHandler= (event) => {
        this.setState({vsmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssSHs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PssSH</h3>
        }else{
            return <h3 className="text-center">Update PssSH</h3>
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
                                            <label> k0: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t3: </label>
                                            #formFields( $attribute, 'create')
                                            <label> t4: </label>
                                            #formFields( $attribute, 'create')
                                            <label> td: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vsmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePssSH}>Save</button>
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

export default CreatePssSHComponent
