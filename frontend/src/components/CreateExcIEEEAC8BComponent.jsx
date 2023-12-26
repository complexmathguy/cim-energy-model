import React, { Component } from 'react'
import ExcIEEEAC8BService from '../services/ExcIEEEAC8BService';

class CreateExcIEEEAC8BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ka: '',
                kc: '',
                kd: '',
                kdr: '',
                ke: '',
                kir: '',
                kpr: '',
                seve1: '',
                seve2: '',
                ta: '',
                tdr: '',
                te: '',
                ve1: '',
                ve2: '',
                vemin: '',
                vfemax: '',
                vrmax: '',
                vrmin: ''
        }
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekdHandler = this.changekdHandler.bind(this);
        this.changekdrHandler = this.changekdrHandler.bind(this);
        this.changekeHandler = this.changekeHandler.bind(this);
        this.changekirHandler = this.changekirHandler.bind(this);
        this.changekprHandler = this.changekprHandler.bind(this);
        this.changeseve1Handler = this.changeseve1Handler.bind(this);
        this.changeseve2Handler = this.changeseve2Handler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetdrHandler = this.changetdrHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
        this.changeve1Handler = this.changeve1Handler.bind(this);
        this.changeve2Handler = this.changeve2Handler.bind(this);
        this.changeveminHandler = this.changeveminHandler.bind(this);
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
            ExcIEEEAC8BService.getExcIEEEAC8BById(this.state.id).then( (res) =>{
                let excIEEEAC8B = res.data;
                this.setState({
                    ka: excIEEEAC8B.ka,
                    kc: excIEEEAC8B.kc,
                    kd: excIEEEAC8B.kd,
                    kdr: excIEEEAC8B.kdr,
                    ke: excIEEEAC8B.ke,
                    kir: excIEEEAC8B.kir,
                    kpr: excIEEEAC8B.kpr,
                    seve1: excIEEEAC8B.seve1,
                    seve2: excIEEEAC8B.seve2,
                    ta: excIEEEAC8B.ta,
                    tdr: excIEEEAC8B.tdr,
                    te: excIEEEAC8B.te,
                    ve1: excIEEEAC8B.ve1,
                    ve2: excIEEEAC8B.ve2,
                    vemin: excIEEEAC8B.vemin,
                    vfemax: excIEEEAC8B.vfemax,
                    vrmax: excIEEEAC8B.vrmax,
                    vrmin: excIEEEAC8B.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEAC8B = (e) => {
        e.preventDefault();
        let excIEEEAC8B = {
                excIEEEAC8BId: this.state.id,
                ka: this.state.ka,
                kc: this.state.kc,
                kd: this.state.kd,
                kdr: this.state.kdr,
                ke: this.state.ke,
                kir: this.state.kir,
                kpr: this.state.kpr,
                seve1: this.state.seve1,
                seve2: this.state.seve2,
                ta: this.state.ta,
                tdr: this.state.tdr,
                te: this.state.te,
                ve1: this.state.ve1,
                ve2: this.state.ve2,
                vemin: this.state.vemin,
                vfemax: this.state.vfemax,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excIEEEAC8B => ' + JSON.stringify(excIEEEAC8B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEAC8B.excIEEEAC8BId=''
            ExcIEEEAC8BService.createExcIEEEAC8B(excIEEEAC8B).then(res =>{
                this.props.history.push('/excIEEEAC8Bs');
            });
        }else{
            ExcIEEEAC8BService.updateExcIEEEAC8B(excIEEEAC8B).then( res => {
                this.props.history.push('/excIEEEAC8Bs');
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
    changekdrHandler= (event) => {
        this.setState({kdr: event.target.value});
    }
    changekeHandler= (event) => {
        this.setState({ke: event.target.value});
    }
    changekirHandler= (event) => {
        this.setState({kir: event.target.value});
    }
    changekprHandler= (event) => {
        this.setState({kpr: event.target.value});
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
    changetdrHandler= (event) => {
        this.setState({tdr: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }
    changeve1Handler= (event) => {
        this.setState({ve1: event.target.value});
    }
    changeve2Handler= (event) => {
        this.setState({ve2: event.target.value});
    }
    changeveminHandler= (event) => {
        this.setState({vemin: event.target.value});
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
        this.props.history.push('/excIEEEAC8Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEAC8B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEAC8B</h3>
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
                                            <label> kdr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ke: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kir: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> seve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tdr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ve2: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vemin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vfemax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEAC8B}>Save</button>
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

export default CreateExcIEEEAC8BComponent
