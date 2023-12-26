import React, { Component } from 'react'
import ExcAC2AService from '../services/ExcAC2AService';

class CreateExcAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                hvgate: '',
                ka: '',
                kb: '',
                kb1: '',
                kc: '',
                kd: '',
                ke: '',
                kf: '',
                kh: '',
                kl: '',
                kl1: '',
                ks: '',
                lvgate: '',
                seve1: '',
                seve2: '',
                ta: '',
                tb: '',
                tc: '',
                te: '',
                tf: '',
                vamax: '',
                vamin: '',
                ve1: '',
                ve2: '',
                vfemax: '',
                vlr: '',
                vrmax: '',
                vrmin: ''
        }
        this.changehvgateHandler = this.changehvgateHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekbHandler = this.changekbHandler.bind(this);
        this.changekb1Handler = this.changekb1Handler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekhHandler = this.changekhHandler.bind(this);
        this.changeklHandler = this.changeklHandler.bind(this);
        this.changekl1Handler = this.changekl1Handler.bind(this);
        this.changeksHandler = this.changeksHandler.bind(this);
        this.changelvgateHandler = this.changelvgateHandler.bind(this);
        this.changeseve1Handler = this.changeseve1Handler.bind(this);
        this.changeseve2Handler = this.changeseve2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changeve1Handler = this.changeve1Handler.bind(this);
        this.changeve2Handler = this.changeve2Handler.bind(this);
        this.changevfemaxHandler = this.changevfemaxHandler.bind(this);
        this.changevlrHandler = this.changevlrHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcAC2AService.getExcAC2AById(this.state.id).then( (res) =>{
                let excAC2A = res.data;
                this.setState({
                    hvgate: excAC2A.hvgate,
                    ka: excAC2A.ka,
                    kb: excAC2A.kb,
                    kb1: excAC2A.kb1,
                    kc: excAC2A.kc,
                    kd: excAC2A.kd,
                    ke: excAC2A.ke,
                    kf: excAC2A.kf,
                    kh: excAC2A.kh,
                    kl: excAC2A.kl,
                    kl1: excAC2A.kl1,
                    ks: excAC2A.ks,
                    lvgate: excAC2A.lvgate,
                    seve1: excAC2A.seve1,
                    seve2: excAC2A.seve2,
                    ta: excAC2A.ta,
                    tb: excAC2A.tb,
                    tc: excAC2A.tc,
                    te: excAC2A.te,
                    tf: excAC2A.tf,
                    vamax: excAC2A.vamax,
                    vamin: excAC2A.vamin,
                    ve1: excAC2A.ve1,
                    ve2: excAC2A.ve2,
                    vfemax: excAC2A.vfemax,
                    vlr: excAC2A.vlr,
                    vrmax: excAC2A.vrmax,
                    vrmin: excAC2A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcAC2A = (e) => {
        e.preventDefault();
        let excAC2A = {
                excAC2AId: this.state.id,
                hvgate: this.state.hvgate,
                ka: this.state.ka,
                kb: this.state.kb,
                kb1: this.state.kb1,
                kc: this.state.kc,
                kd: this.state.kd,
                ke: this.state.ke,
                kf: this.state.kf,
                kh: this.state.kh,
                kl: this.state.kl,
                kl1: this.state.kl1,
                ks: this.state.ks,
                lvgate: this.state.lvgate,
                seve1: this.state.seve1,
                seve2: this.state.seve2,
                ta: this.state.ta,
                tb: this.state.tb,
                tc: this.state.tc,
                te: this.state.te,
                tf: this.state.tf,
                vamax: this.state.vamax,
                vamin: this.state.vamin,
                ve1: this.state.ve1,
                ve2: this.state.ve2,
                vfemax: this.state.vfemax,
                vlr: this.state.vlr,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excAC2A => ' + JSON.stringify(excAC2A));

        // step 5
        if(this.state.id === '_add'){
            excAC2A.excAC2AId=''
            ExcAC2AService.createExcAC2A(excAC2A).then(res =>{
                this.props.history.push('/excAC2As');
            });
        }else{
            ExcAC2AService.updateExcAC2A(excAC2A).then( res => {
                this.props.history.push('/excAC2As');
            });
        }
    }
    
    changehvgateHandler= (event) => {
        this.setState({hvgate: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekbHandler= (event) => {
        this.setState({kb: event.target.value});
    }
    changekb1Handler= (event) => {
        this.setState({kb1: event.target.value});
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
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changekhHandler= (event) => {
        this.setState({kh: event.target.value});
    }
    changeklHandler= (event) => {
        this.setState({kl: event.target.value});
    }
    changekl1Handler= (event) => {
        this.setState({kl1: event.target.value});
    }
    changeksHandler= (event) => {
        this.setState({ks: event.target.value});
    }
    changelvgateHandler= (event) => {
        this.setState({lvgate: event.target.value});
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
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
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
    changevfemaxHandler= (event) => {
        this.setState({vfemax: event.target.value});
    }
    changevlrHandler= (event) => {
        this.setState({vlr: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excAC2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcAC2A</h3>
        }else{
            return <h3 className="text-center">Update ExcAC2A</h3>
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
                                            <label> hvgate: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kb1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kh: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kl: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kl1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ks: </label>
                                            #formFields( $attribute, 'create')
                                            <label> lvgate: </label>
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
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vfemax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vlr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcAC2A}>Save</button>
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

export default CreateExcAC2AComponent
