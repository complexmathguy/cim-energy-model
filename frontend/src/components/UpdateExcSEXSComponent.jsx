import React, { Component } from 'react'
import ExcSEXSService from '../services/ExcSEXSService';

class UpdateExcSEXSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
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
        this.updateExcSEXS = this.updateExcSEXS.bind(this);

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

    componentDidMount(){
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

    updateExcSEXS = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcSEXSService.updateExcSEXS(excSEXS).then( res => {
            this.props.history.push('/excSEXSs');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcSEXS</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> efdmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> efdmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tatb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tc: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcSEXS}>Save</button>
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

export default UpdateExcSEXSComponent
