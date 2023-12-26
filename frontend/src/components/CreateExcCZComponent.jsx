import React, { Component } from 'react'
import ExcCZService from '../services/ExcCZService';

class CreateExcCZComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                efdmax: '',
                efdmin: '',
                ka: '',
                ke: '',
                kp: '',
                ta: '',
                tc: '',
                te: '',
                vrmax: '',
                vrmin: ''
        }
        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changeefdminHandler = this.changeefdminHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekpHandler = this.changekpHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcCZService.getExcCZById(this.state.id).then( (res) =>{
                let excCZ = res.data;
                this.setState({
                    efdmax: excCZ.efdmax,
                    efdmin: excCZ.efdmin,
                    ka: excCZ.ka,
                    ke: excCZ.ke,
                    kp: excCZ.kp,
                    ta: excCZ.ta,
                    tc: excCZ.tc,
                    te: excCZ.te,
                    vrmax: excCZ.vrmax,
                    vrmin: excCZ.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcCZ = (e) => {
        e.preventDefault();
        let excCZ = {
                excCZId: this.state.id,
                efdmax: this.state.efdmax,
                efdmin: this.state.efdmin,
                ka: this.state.ka,
                ke: this.state.ke,
                kp: this.state.kp,
                ta: this.state.ta,
                tc: this.state.tc,
                te: this.state.te,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excCZ => ' + JSON.stringify(excCZ));

        // step 5
        if(this.state.id === '_add'){
            excCZ.excCZId=''
            ExcCZService.createExcCZ(excCZ).then(res =>{
                this.props.history.push('/excCZs');
            });
        }else{
            ExcCZService.updateExcCZ(excCZ).then( res => {
                this.props.history.push('/excCZs');
            });
        }
    }
    
    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changeefdminHandler= (event) => {
        this.setState({efdmin: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekpHandler= (event) => {
        this.setState({kp: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excCZs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcCZ</h3>
        }else{
            return <h3 className="text-center">Update ExcCZ</h3>
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
                                            <label> efdmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcCZ}>Save</button>
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

export default CreateExcCZComponent
