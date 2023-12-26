import React, { Component } from 'react'
import ExcIEEEST1AService from '../services/ExcIEEEST1AService';

class CreateExcIEEEST1AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ilr: '',
                ka: '',
                kc: '',
                kf: '',
                klr: '',
                pssin: '',
                ta: '',
                tb: '',
                tb1: '',
                tc: '',
                tc1: '',
                tf: '',
                uelin: '',
                vamax: '',
                vamin: '',
                vimax: '',
                vimin: '',
                vrmax: '',
                vrmin: ''
        }
        this.changeilrHandler = this.changeilrHandler.bind(this);
        this.changekaHandler = this.changekaHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changekfHandler = this.changekfHandler.bind(this);
        this.changeklrHandler = this.changeklrHandler.bind(this);
        this.changepssinHandler = this.changepssinHandler.bind(this);
        this.changetaHandler = this.changetaHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetb1Handler = this.changetb1Handler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changetc1Handler = this.changetc1Handler.bind(this);
        this.changetfHandler = this.changetfHandler.bind(this);
        this.changeuelinHandler = this.changeuelinHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEST1AService.getExcIEEEST1AById(this.state.id).then( (res) =>{
                let excIEEEST1A = res.data;
                this.setState({
                    ilr: excIEEEST1A.ilr,
                    ka: excIEEEST1A.ka,
                    kc: excIEEEST1A.kc,
                    kf: excIEEEST1A.kf,
                    klr: excIEEEST1A.klr,
                    pssin: excIEEEST1A.pssin,
                    ta: excIEEEST1A.ta,
                    tb: excIEEEST1A.tb,
                    tb1: excIEEEST1A.tb1,
                    tc: excIEEEST1A.tc,
                    tc1: excIEEEST1A.tc1,
                    tf: excIEEEST1A.tf,
                    uelin: excIEEEST1A.uelin,
                    vamax: excIEEEST1A.vamax,
                    vamin: excIEEEST1A.vamin,
                    vimax: excIEEEST1A.vimax,
                    vimin: excIEEEST1A.vimin,
                    vrmax: excIEEEST1A.vrmax,
                    vrmin: excIEEEST1A.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST1A = (e) => {
        e.preventDefault();
        let excIEEEST1A = {
                excIEEEST1AId: this.state.id,
                ilr: this.state.ilr,
                ka: this.state.ka,
                kc: this.state.kc,
                kf: this.state.kf,
                klr: this.state.klr,
                pssin: this.state.pssin,
                ta: this.state.ta,
                tb: this.state.tb,
                tb1: this.state.tb1,
                tc: this.state.tc,
                tc1: this.state.tc1,
                tf: this.state.tf,
                uelin: this.state.uelin,
                vamax: this.state.vamax,
                vamin: this.state.vamin,
                vimax: this.state.vimax,
                vimin: this.state.vimin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excIEEEST1A => ' + JSON.stringify(excIEEEST1A));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST1A.excIEEEST1AId=''
            ExcIEEEST1AService.createExcIEEEST1A(excIEEEST1A).then(res =>{
                this.props.history.push('/excIEEEST1As');
            });
        }else{
            ExcIEEEST1AService.updateExcIEEEST1A(excIEEEST1A).then( res => {
                this.props.history.push('/excIEEEST1As');
            });
        }
    }
    
    changeilrHandler= (event) => {
        this.setState({ilr: event.target.value});
    }
    changekaHandler= (event) => {
        this.setState({ka: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changekfHandler= (event) => {
        this.setState({kf: event.target.value});
    }
    changeklrHandler= (event) => {
        this.setState({klr: event.target.value});
    }
    changepssinHandler= (event) => {
        this.setState({pssin: event.target.value});
    }
    changetaHandler= (event) => {
        this.setState({ta: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changetb1Handler= (event) => {
        this.setState({tb1: event.target.value});
    }
    changetcHandler= (event) => {
        this.setState({tc: event.target.value});
    }
    changetc1Handler= (event) => {
        this.setState({tc1: event.target.value});
    }
    changetfHandler= (event) => {
        this.setState({tf: event.target.value});
    }
    changeuelinHandler= (event) => {
        this.setState({uelin: event.target.value});
    }
    changevamaxHandler= (event) => {
        this.setState({vamax: event.target.value});
    }
    changevaminHandler= (event) => {
        this.setState({vamin: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changeviminHandler= (event) => {
        this.setState({vimin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST1As');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST1A</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST1A</h3>
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
                                            <label> ilr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ka: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> klr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pssin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ta: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uelin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST1A}>Save</button>
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

export default CreateExcIEEEST1AComponent
