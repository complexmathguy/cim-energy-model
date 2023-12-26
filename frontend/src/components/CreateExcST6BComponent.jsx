import React, { Component } from 'react'
import ExcST6BService from '../services/ExcST6BService';

class CreateExcST6BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                ilr: '',
                k1: '',
                kcl: '',
                kff: '',
                kg: '',
                kia: '',
                klr: '',
                km: '',
                kpa: '',
                kvd: '',
                oelin: '',
                tg: '',
                ts: '',
                tvd: '',
                vamax: '',
                vamin: '',
                vilim: '',
                vimax: '',
                vimin: '',
                vmult: '',
                vrmax: '',
                vrmin: '',
                xc: ''
        }
        this.changeilrHandler = this.changeilrHandler.bind(this);
        this.changek1Handler = this.changek1Handler.bind(this);
        this.changekclHandler = this.changekclHandler.bind(this);
        this.changekffHandler = this.changekffHandler.bind(this);
        this.changekgHandler = this.changekgHandler.bind(this);
        this.changekiaHandler = this.changekiaHandler.bind(this);
        this.changeklrHandler = this.changeklrHandler.bind(this);
        this.changekmHandler = this.changekmHandler.bind(this);
        this.changekpaHandler = this.changekpaHandler.bind(this);
        this.changekvdHandler = this.changekvdHandler.bind(this);
        this.changeoelinHandler = this.changeoelinHandler.bind(this);
        this.changetgHandler = this.changetgHandler.bind(this);
        this.changetsHandler = this.changetsHandler.bind(this);
        this.changetvdHandler = this.changetvdHandler.bind(this);
        this.changevamaxHandler = this.changevamaxHandler.bind(this);
        this.changevaminHandler = this.changevaminHandler.bind(this);
        this.changevilimHandler = this.changevilimHandler.bind(this);
        this.changevimaxHandler = this.changevimaxHandler.bind(this);
        this.changeviminHandler = this.changeviminHandler.bind(this);
        this.changevmultHandler = this.changevmultHandler.bind(this);
        this.changevrmaxHandler = this.changevrmaxHandler.bind(this);
        this.changevrminHandler = this.changevrminHandler.bind(this);
        this.changexcHandler = this.changexcHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcST6BService.getExcST6BById(this.state.id).then( (res) =>{
                let excST6B = res.data;
                this.setState({
                    ilr: excST6B.ilr,
                    k1: excST6B.k1,
                    kcl: excST6B.kcl,
                    kff: excST6B.kff,
                    kg: excST6B.kg,
                    kia: excST6B.kia,
                    klr: excST6B.klr,
                    km: excST6B.km,
                    kpa: excST6B.kpa,
                    kvd: excST6B.kvd,
                    oelin: excST6B.oelin,
                    tg: excST6B.tg,
                    ts: excST6B.ts,
                    tvd: excST6B.tvd,
                    vamax: excST6B.vamax,
                    vamin: excST6B.vamin,
                    vilim: excST6B.vilim,
                    vimax: excST6B.vimax,
                    vimin: excST6B.vimin,
                    vmult: excST6B.vmult,
                    vrmax: excST6B.vrmax,
                    vrmin: excST6B.vrmin,
                    xc: excST6B.xc
                });
            });
        }        
    }
    saveOrUpdateExcST6B = (e) => {
        e.preventDefault();
        let excST6B = {
                excST6BId: this.state.id,
                ilr: this.state.ilr,
                k1: this.state.k1,
                kcl: this.state.kcl,
                kff: this.state.kff,
                kg: this.state.kg,
                kia: this.state.kia,
                klr: this.state.klr,
                km: this.state.km,
                kpa: this.state.kpa,
                kvd: this.state.kvd,
                oelin: this.state.oelin,
                tg: this.state.tg,
                ts: this.state.ts,
                tvd: this.state.tvd,
                vamax: this.state.vamax,
                vamin: this.state.vamin,
                vilim: this.state.vilim,
                vimax: this.state.vimax,
                vimin: this.state.vimin,
                vmult: this.state.vmult,
                vrmax: this.state.vrmax,
                vrmin: this.state.vrmin,
                xc: this.state.xc
            };
        console.log('excST6B => ' + JSON.stringify(excST6B));

        // step 5
        if(this.state.id === '_add'){
            excST6B.excST6BId=''
            ExcST6BService.createExcST6B(excST6B).then(res =>{
                this.props.history.push('/excST6Bs');
            });
        }else{
            ExcST6BService.updateExcST6B(excST6B).then( res => {
                this.props.history.push('/excST6Bs');
            });
        }
    }
    
    changeilrHandler= (event) => {
        this.setState({ilr: event.target.value});
    }
    changek1Handler= (event) => {
        this.setState({k1: event.target.value});
    }
    changekclHandler= (event) => {
        this.setState({kcl: event.target.value});
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
    changekvdHandler= (event) => {
        this.setState({kvd: event.target.value});
    }
    changeoelinHandler= (event) => {
        this.setState({oelin: event.target.value});
    }
    changetgHandler= (event) => {
        this.setState({tg: event.target.value});
    }
    changetsHandler= (event) => {
        this.setState({ts: event.target.value});
    }
    changetvdHandler= (event) => {
        this.setState({tvd: event.target.value});
    }
    changevamaxHandler= (event) => {
        this.setState({vamax: event.target.value});
    }
    changevaminHandler= (event) => {
        this.setState({vamin: event.target.value});
    }
    changevilimHandler= (event) => {
        this.setState({vilim: event.target.value});
    }
    changevimaxHandler= (event) => {
        this.setState({vimax: event.target.value});
    }
    changeviminHandler= (event) => {
        this.setState({vimin: event.target.value});
    }
    changevmultHandler= (event) => {
        this.setState({vmult: event.target.value});
    }
    changevrmaxHandler= (event) => {
        this.setState({vrmax: event.target.value});
    }
    changevrminHandler= (event) => {
        this.setState({vrmin: event.target.value});
    }
    changexcHandler= (event) => {
        this.setState({xc: event.target.value});
    }

    cancel(){
        this.props.history.push('/excST6Bs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcST6B</h3>
        }else{
            return <h3 className="text-center">Update ExcST6B</h3>
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
                                            <label> k1: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kcl: </label>
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
                                            <label> kvd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> oelin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tg: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ts: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tvd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vamin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vilim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vimin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vmult: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> vrmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xc: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcST6B}>Save</button>
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

export default CreateExcST6BComponent
