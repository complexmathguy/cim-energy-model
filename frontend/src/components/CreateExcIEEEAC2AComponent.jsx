import React, { Component } from 'react'
import ExcIEEEAC2AService from '../services/ExcIEEEAC2AService';

class CreateExcIEEEAC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ka: '',
                kb: '',
                kc: '',
                kd: '',
                ke: '',
                kf: '',
                kh: '',
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
                vrmax: '',
                vrmin: ''
        }
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekbHandler = this.changekbHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekhHandler = this.changekhHandler.bind(this);
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
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEAC2AService.getExcIEEEAC2AById(this.state.id).then( (res) =>{
                let excIEEEAC2A = res.data;
                this.setState({
                    ka: excIEEEAC2A.ka,
                    kb: excIEEEAC2A.kb,
                    kc: excIEEEAC2A.kc,
                    kd: excIEEEAC2A.kd,
                    ke: excIEEEAC2A.ke,
                    kf: excIEEEAC2A.kf,
                    kh: excIEEEAC2A.kh,
                    seve1: excIEEEAC2A.seve1,
                    seve2: excIEEEAC2A.seve2,
                    ta: excIEEEAC2A.ta,
                    tb: excIEEEAC2A.tb,
                    tc: excIEEEAC2A.tc,
                    te: excIEEEAC2A.te,
                    tf: excIEEEAC2A.tf,
                    vamax: excIEEEAC2A.vamax,
                    vamin: excIEEEAC2A.vamin,
                    ve1: excIEEEAC2A.ve1,
                    ve2: excIEEEAC2A.ve2,
                    vfemax: excIEEEAC2A.vfemax,
                    vrmax: excIEEEAC2A.vrmax,
                    vrmin: excIEEEAC2A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC2A = (e) => {
        e.preventDefault();
        let excIEEEAC2A = {
                excIEEEAC2AId: this.state.id,
                ka: this.state.ka,
                kb: this.state.kb,
                kc: this.state.kc,
                kd: this.state.kd,
                ke: this.state.ke,
                kf: this.state.kf,
                kh: this.state.kh,
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
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excIEEEAC2A => ' + JSON.stringify(excIEEEAC2A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC2A.excIEEEAC2AId=''
            ExcIEEEAC2AService.createExcIEEEAC2A(excIEEEAC2A).then(res =>{
                this.props.history.push('/excIEEEAC2As');
            });
        }else{
            ExcIEEEAC2AService.updateExcIEEEAC2A(excIEEEAC2A).then( res => {
                this.props.history.push('/excIEEEAC2As');
            });
        }
    }
    
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekbHandler= (event) => {
        this.setState({kb: event.target.value});
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
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEAC2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC2A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC2A</h3>
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
                                            <label> kb: </label>
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
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC2A}>Save</button>
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

export default CreateExcIEEEAC2AComponent
