import React, { Component } from 'react'
import ExcAC6AService from '../services/ExcAC6AService';

class CreateExcAC6AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ka: '',
                kc: '',
                kd: '',
                ke: '',
                kh: '',
                ks: '',
                seve1: '',
                seve2: '',
                ta: '',
                tb: '',
                tc: '',
                te: '',
                th: '',
                tj: '',
                tk: '',
                vamax: '',
                vamin: '',
                ve1: '',
                ve2: '',
                vfelim: '',
                vhmax: '',
                vrmax: '',
                vrmin: ''
        }
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekhHandler = this.changekhHandler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changeseve1Handler = this.changeseve1Handler.bind(this);
        this.changeseve2Handler = this.changeseve2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changethHandler = this.changethHandler.bind(this);
        this.changetjHandler = this.changetjHandler.bind(this);
        this.changetkHandler = this.changetkHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changeve1Handler = this.changeve1Handler.bind(this);
        this.changeve2Handler = this.changeve2Handler.bind(this);
        this.changevfelimHandler = this.changevfelimHandler.bind(this);
        this.changevhmaxHandler = this.changevhmaxHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcAC6AService.getExcAC6AById(this.state.id).then( (res) =>{
                let excAC6A = res.data;
                this.setState({
                    ka: excAC6A.ka,
                    kc: excAC6A.kc,
                    kd: excAC6A.kd,
                    ke: excAC6A.ke,
                    kh: excAC6A.kh,
                    ks: excAC6A.ks,
                    seve1: excAC6A.seve1,
                    seve2: excAC6A.seve2,
                    ta: excAC6A.ta,
                    tb: excAC6A.tb,
                    tc: excAC6A.tc,
                    te: excAC6A.te,
                    th: excAC6A.th,
                    tj: excAC6A.tj,
                    tk: excAC6A.tk,
                    vamax: excAC6A.vamax,
                    vamin: excAC6A.vamin,
                    ve1: excAC6A.ve1,
                    ve2: excAC6A.ve2,
                    vfelim: excAC6A.vfelim,
                    vhmax: excAC6A.vhmax,
                    vrmax: excAC6A.vrmax,
                    vrmin: excAC6A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcAC6A = (e) => {
        e.preventDefault();
        let excAC6A = {
                excAC6AId: this.state.id,
                ka: this.state.ka,
                kc: this.state.kc,
                kd: this.state.kd,
                ke: this.state.ke,
                kh: this.state.kh,
                ks: this.state.ks,
                seve1: this.state.seve1,
                seve2: this.state.seve2,
                ta: this.state.ta,
                tb: this.state.tb,
                tc: this.state.tc,
                te: this.state.te,
                th: this.state.th,
                tj: this.state.tj,
                tk: this.state.tk,
                vamax: this.state.vamax,
                vamin: this.state.vamin,
                ve1: this.state.ve1,
                ve2: this.state.ve2,
                vfelim: this.state.vfelim,
                vhmax: this.state.vhmax,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excAC6A => ' + JSON.stringify(excAC6A));

        // step 5
        if(this.state.id === '_add'){
            excAC6A.excAC6AId=''
            ExcAC6AService.createExcAC6A(excAC6A).then(res =>{
                this.props.history.push('/excAC6As');
            });
        }else{
            ExcAC6AService.updateExcAC6A(excAC6A).then( res => {
                this.props.history.push('/excAC6As');
            });
        }
    }
    
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekdHandler= (event) => {
        this.setState({kd: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekhHandler= (event) => {
        this.setState({kh: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changeseve1Handler= (event) => {
        this.setState({seve1: event.target.value});
    }
    changeseve2Handler= (event) => {
        this.setState({seve2: event.target.value});
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
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changethHandler= (event) => {
        this.setState({th: event.target.value});
    }
    changetjHandler= (event) => {
        this.setState({tj: event.target.value});
    }
    changetkHandler= (event) => {
        this.setState({tk: event.target.value});
    }
    changevamaxHandler= (event) => {
        this.setState({vamax: event.target.value});
    }
    changevaminHandler= (event) => {
        this.setState({vamin: event.target.value});
    }
    changeve1Handler= (event) => {
        this.setState({ve1: event.target.value});
    }
    changeve2Handler= (event) => {
        this.setState({ve2: event.target.value});
    }
    changevfelimHandler= (event) => {
        this.setState({vfelim: event.target.value});
    }
    changevhmaxHandler= (event) => {
        this.setState({vhmax: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAC6As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC6A</h3>
        }else{
            return <h3 className="text-center">Update ExcAC6A</h3>
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
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kh: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> th: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tj: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tk: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vfelim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vhmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC6A}>Save</button>
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

export default CreateExcAC6AComponent
