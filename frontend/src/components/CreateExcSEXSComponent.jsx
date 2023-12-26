import React, { Component } from 'react'
import ExcSEXSService from '../services/ExcSEXSService';

class CreateExcSEXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                efdmax: '',
                efdmin: '',
                emax: '',
                emin: '',
                k: '',
                kc: '',
                tatb: '',
                tb: '',
                tc: '',
                te: ''
        }
        this.changeefdmaxHandler = this.changeefdmaxHandler.bind(this);
        this.changeefdminHandler = this.changeefdminHandler.bind(this);
        this.changeemaxHandler = this.changeemaxHandler.bind(this);
        this.changeeminHandler = this.changeeminHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changekcHandler = this.changekcHandler.bind(this);
        this.changetatbHandler = this.changetatbHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changetcHandler = this.changetcHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ExcSEXSService.getExcSEXSById(this.state.id).then( (res) =>{
                let excSEXS = res.data;
                this.setState({
                    efdmax: excSEXS.efdmax,
                    efdmin: excSEXS.efdmin,
                    emax: excSEXS.emax,
                    emin: excSEXS.emin,
                    k: excSEXS.k,
                    kc: excSEXS.kc,
                    tatb: excSEXS.tatb,
                    tb: excSEXS.tb,
                    tc: excSEXS.tc,
                    te: excSEXS.te
                });
            });
        }        
    }
    saveOrUpdateExcSEXS = (e) => {
        e.preventDefault();
        let excSEXS = {
                excSEXSId: this.state.id,
                efdmax: this.state.efdmax,
                efdmin: this.state.efdmin,
                emax: this.state.emax,
                emin: this.state.emin,
                k: this.state.k,
                kc: this.state.kc,
                tatb: this.state.tatb,
                tb: this.state.tb,
                tc: this.state.tc,
                te: this.state.te
            };
        console.log('excSEXS => ' + JSON.stringify(excSEXS));

        // step 5
        if(this.state.id === '_add'){
            excSEXS.excSEXSId=''
            ExcSEXSService.createExcSEXS(excSEXS).then(res =>{
                this.props.history.push('/excSEXSs');
            });
        }else{
            ExcSEXSService.updateExcSEXS(excSEXS).then( res => {
                this.props.history.push('/excSEXSs');
            });
        }
    }
    
    changeefdmaxHandler= (event) => {
        this.setState({efdmax: event.target.value});
    }
    changeefdminHandler= (event) => {
        this.setState({efdmin: event.target.value});
    }
    changeemaxHandler= (event) => {
        this.setState({emax: event.target.value});
    }
    changeeminHandler= (event) => {
        this.setState({emin: event.target.value});
    }
    changekHandler= (event) => {
        this.setState({k: event.target.value});
    }
    changekcHandler= (event) => {
        this.setState({kc: event.target.value});
    }
    changetatbHandler= (event) => {
        this.setState({tatb: event.target.value});
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

    cancel(){
        this.props.history.push('/excSEXSs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ExcSEXS</h3>
        }else{
            return <h3 className="text-center">Update ExcSEXS</h3>
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
                                            <label> emax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> emin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> k: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tatb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> te: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateExcSEXS}>Save</button>
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

export default CreateExcSEXSComponent
