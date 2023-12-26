import React, { Component } from 'react'
import ExcDC3AService from '../services/ExcDC3AService';

class CreateExcDC3AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                edfmax: '',
                efd1: '',
                efd2: '',
                efdlim: '',
                efdmin: '',
                exclim: '',
                ke: '',
                kr: '',
                ks: '',
                kv: '',
                seefd1: '',
                seefd2: '',
                te: '',
                trh: '',
                vrmax: '',
                vrmin: ''
        }
        this.changeedfmaxHandler = this.changeedfmaxHandler.bind(this);
        this.changeefd1Handler = this.changeefd1Handler.bind(this);
        this.changeefd2Handler = this.changeefd2Handler.bind(this);
        this.changeefdlimHandler = this.changeefdlimHandler.bind(this);
        this.changeefdminHandler = this.changeefdminHandler.bind(this);
        this.changeexclimHandler = this.changeexclimHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekrHandler = this.changekrHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changekvHandler = this.changekvHandler.bind(this);
        this.changeseefd1Handler = this.changeseefd1Handler.bind(this);
        this.changeseefd2Handler = this.changeseefd2Handler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetrhHandler = this.changetrhHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcDC3AService.getExcDC3AById(this.state.id).then( (res) =>{
                let excDC3A = res.data;
                this.setState({
                    edfmax: excDC3A.edfmax,
                    efd1: excDC3A.efd1,
                    efd2: excDC3A.efd2,
                    efdlim: excDC3A.efdlim,
                    efdmin: excDC3A.efdmin,
                    exclim: excDC3A.exclim,
                    ke: excDC3A.ke,
                    kr: excDC3A.kr,
                    ks: excDC3A.ks,
                    kv: excDC3A.kv,
                    seefd1: excDC3A.seefd1,
                    seefd2: excDC3A.seefd2,
                    te: excDC3A.te,
                    trh: excDC3A.trh,
                    vrmax: excDC3A.vrmax,
                    vrmin: excDC3A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcDC3A = (e) => {
        e.preventDefault();
        let excDC3A = {
                excDC3AId: this.state.id,
                edfmax: this.state.edfmax,
                efd1: this.state.efd1,
                efd2: this.state.efd2,
                efdlim: this.state.efdlim,
                efdmin: this.state.efdmin,
                exclim: this.state.exclim,
                ke: this.state.ke,
                kr: this.state.kr,
                ks: this.state.ks,
                kv: this.state.kv,
                seefd1: this.state.seefd1,
                seefd2: this.state.seefd2,
                te: this.state.te,
                trh: this.state.trh,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excDC3A => ' + JSON.stringify(excDC3A));

        // step 5
        if(this.state.id === '_add'){
            excDC3A.excDC3AId=''
            ExcDC3AService.createExcDC3A(excDC3A).then(res =>{
                this.props.history.push('/excDC3As');
            });
        }else{
            ExcDC3AService.updateExcDC3A(excDC3A).then( res => {
                this.props.history.push('/excDC3As');
            });
        }
    }
    
    changeedfmaxHandler= (event) => {
        this.setState({edfmax: event.target.value});
    }
    changeefd1Handler= (event) => {
        this.setState({efd1: event.target.value});
    }
    changeefd2Handler= (event) => {
        this.setState({efd2: event.target.value});
    }
    changeefdlimHandler= (event) => {
        this.setState({efdlim: event.target.value});
    }
    changeefdminHandler= (event) => {
        this.setState({efdmin: event.target.value});
    }
    changeexclimHandler= (event) => {
        this.setState({exclim: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekrHandler= (event) => {
        this.setState({kr: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changekvHandler= (event) => {
        this.setState({kv: event.target.value});
    }
    changeseefd1Handler= (event) => {
        this.setState({seefd1: event.target.value});
    }
    changeseefd2Handler= (event) => {
        this.setState({seefd2: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changetrhHandler= (event) => {
        this.setState({trh: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excDC3As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcDC3A</h3>
        }else{
            return <h3 className="text-center">Update ExcDC3A</h3>
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
                                            <label> edfmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efd1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efd2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efdlim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> efdmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> exclim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kv: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seefd1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seefd2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> trh: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcDC3A}>Save</button>
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

export default CreateExcDC3AComponent
