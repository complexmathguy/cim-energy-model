import React, { Component } from 'react'
import ExcIEEEST6BService from '../services/ExcIEEEST6BService';

class CreateExcIEEEST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ilr: '',
                kci: '',
                kff: '',
                kg: '',
                kia: '',
                klr: '',
                km: '',
                kpa: '',
                oelin: '',
                tg: '',
                vamax: '',
                vamin: '',
                vrmax: '',
                vrmin: ''
        }
        this.changeilrHandler = this.changeilrHandler.bind(this);
        this.changekciHandler = this.changekciHandler.bind(this);
        this.changekffHandler = this.changekffHandler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changekiaHandler = this.changekiaHandler.bind(this);
        this.changeklrHandler = this.changeklrHandler.bind(this);
        this.changekmHandler = this.changekmHandler.bind(this);
        this.changekpaHandler = this.changekpaHandler.bind(this);
        this.changeoelinHandler = this.changeoelinHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcIEEEST6BService.getExcIEEEST6BById(this.state.id).then( (res) =>{
                let excIEEEST6B = res.data;
                this.setState({
                    ilr: excIEEEST6B.ilr,
                    kci: excIEEEST6B.kci,
                    kff: excIEEEST6B.kff,
                    kg: excIEEEST6B.kg,
                    kia: excIEEEST6B.kia,
                    klr: excIEEEST6B.klr,
                    km: excIEEEST6B.km,
                    kpa: excIEEEST6B.kpa,
                    oelin: excIEEEST6B.oelin,
                    tg: excIEEEST6B.tg,
                    vamax: excIEEEST6B.vamax,
                    vamin: excIEEEST6B.vamin,
                    vrmax: excIEEEST6B.vrmax,
                    vrmin: excIEEEST6B.vrmin
                });
            });
        }        
    }
    saveOrUpdateExcIEEEST6B = (e) => {
        e.preventDefault();
        let excIEEEST6B = {
                excIEEEST6BId: this.state.id,
                ilr: this.state.ilr,
                kci: this.state.kci,
                kff: this.state.kff,
                kg: this.state.kg,
                kia: this.state.kia,
                klr: this.state.klr,
                km: this.state.km,
                kpa: this.state.kpa,
                oelin: this.state.oelin,
                tg: this.state.tg,
                vamax: this.state.vamax,
                vamin: this.state.vamin,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin
            };
        console.log('excIEEEST6B => ' + JSON.stringify(excIEEEST6B));

        // step 5
        if(this.state.id === '_add'){
            excIEEEST6B.excIEEEST6BId=''
            ExcIEEEST6BService.createExcIEEEST6B(excIEEEST6B).then(res =>{
                this.props.history.push('/excIEEEST6Bs');
            });
        }else{
            ExcIEEEST6BService.updateExcIEEEST6B(excIEEEST6B).then( res => {
                this.props.history.push('/excIEEEST6Bs');
            });
        }
    }
    
    changeilrHandler= (event) => {
        this.setState({ilr: event.target.value});
    }
    changekciHandler= (event) => {
        this.setState({kci: event.target.value});
    }
    changekffHandler= (event) => {
        this.setState({kff: event.target.value});
    }
    changekgHandler= (event) => {
        this.setState({kg: event.target.value});
    }
    changekiaHandler= (event) => {
        this.setState({kia: event.target.value});
    }
    changeklrHandler= (event) => {
        this.setState({klr: event.target.value});
    }
    changekmHandler= (event) => {
        this.setState({km: event.target.value});
    }
    changekpaHandler= (event) => {
        this.setState({kpa: event.target.value});
    }
    changeoelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changevamaxHandler= (event) => {
        this.setState({vamax: event.target.value});
    }
    changevaminHandler= (event) => {
        this.setState({vamin: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/excIEEEST6Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcIEEEST6B</h3>
        }else{
            return <h3 className="text-center">Update ExcIEEEST6B</h3>
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
                                            <label> kci: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kff: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kia: </label>
                                            #formFields( $attribute, 'create')
                                            <label> klr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> km: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpa: </label>
                                            #formFields( $attribute, 'create')
                                            <label> oelin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcIEEEST6B}>Save</button>
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

export default CreateExcIEEEST6BComponent
