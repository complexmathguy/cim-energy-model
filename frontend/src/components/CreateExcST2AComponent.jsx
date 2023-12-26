import React, { Component } from 'react'
import ExcST2AService from '../services/ExcST2AService';

class CreateExcST2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                efdmax: '',
                ka: '',
                kc: '',
                ke: '',
                kf: '',
                ki: '',
                kp: '',
                ta: '',
                tb: '',
                tc: '',
                te: '',
                tf: '',
                uelin: '',
                vrmax: '',
                vrmin: ''
        }
        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changekiHandler = this.changekiHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changeuelinHandler = this.changeuelinHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcST2AService.getExcST2AById(this.state.id).then( (res) =>{
                let excST2A = res.data;
                this.setState({
                    efdmax: excST2A.efdmax,
                    ka: excST2A.ka,
                    kc: excST2A.kc,
                    ke: excST2A.ke,
                    kf: excST2A.kf,
                    ki: excST2A.ki,
                    kp: excST2A.kp,
                    ta: excST2A.ta,
                    tb: excST2A.tb,
                    tc: excST2A.tc,
                    te: excST2A.te,
                    tf: excST2A.tf,
                    uelin: excST2A.uelin,
                    vrmax: excST2A.vrmax,
                    vrmin: excST2A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcST2A = (e) => {
        e.preventDefault();
        let excST2A = {
                excST2AId: this.state.id,
                efdmax: this.state.efdmax,
                ka: this.state.ka,
                kc: this.state.kc,
                ke: this.state.ke,
                kf: this.state.kf,
                ki: this.state.ki,
                kp: this.state.kp,
                ta: this.state.ta,
                tb: this.state.tb,
                tc: this.state.tc,
                te: this.state.te,
                tf: this.state.tf,
                uelin: this.state.uelin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excST2A => ' + JSON.stringify(excST2A));

        // step 5
        if(this.state.id === '_add'){
            excST2A.excST2AId=''
            ExcST2AService.createExcST2A(excST2A).then(res =>{
                this.props.history.push('/excST2As');
            });
        }else{
            ExcST2AService.updateExcST2A(excST2A).then( res => {
                this.props.history.push('/excST2As');
            });
        }
    }
    
    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changekiHandler= (event) => {
        this.setState({ki: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
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
    changeuelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST2As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcST2A</h3>
        }else{
            return <h3 className="text-center">Update ExcST2A</h3>
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
                                            <label> efdmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ki: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kp: </label>
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
                                            <label> uelin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcST2A}>Save</button>
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

export default CreateExcST2AComponent
