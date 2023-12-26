import React, { Component } from 'react'
import ExcSCRXService from '../services/ExcSCRXService';

class UpdateExcSCRXComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                cswitch: '',
                emax: '',
                emin: '',
                k: '',
                rcrfd: '',
                tatb: '',
                tb: '',
                te: ''
        }
        this.updateExcSCRX = this.updateExcSCRX.bind(this);

        this.changecswitchHandler = this.changecswitchHandler.bind(this);
        this.changeemaxHandler = this.changeemaxHandler.bind(this);
        this.changeeminHandler = this.changeeminHandler.bind(this);
        this.changekHandler = this.changekHandler.bind(this);
        this.changercrfdHandler = this.changercrfdHandler.bind(this);
        this.changetatbHandler = this.changetatbHandler.bind(this);
        this.changetbHandler = this.changetbHandler.bind(this);
        this.changeteHandler = this.changeteHandler.bind(this);
    }

    componentDidMount(){
        ExcSCRXService.getExcSCRXById(this.state.id).then( (res) =>{
            let excSCRX = res.data;
            this.setState({
                cswitch: excSCRX.cswitch,
                emax: excSCRX.emax,
                emin: excSCRX.emin,
                k: excSCRX.k,
                rcrfd: excSCRX.rcrfd,
                tatb: excSCRX.tatb,
                tb: excSCRX.tb,
                te: excSCRX.te
            });
        });
    }

    updateExcSCRX = (e) => {
        e.preventDefault();
        let excSCRX = {
            excSCRXId: this.state.id,
            cswitch: this.state.cswitch,
            emax: this.state.emax,
            emin: this.state.emin,
            k: this.state.k,
            rcrfd: this.state.rcrfd,
            tatb: this.state.tatb,
            tb: this.state.tb,
            te: this.state.te
        };
        console.log('excSCRX => ' + JSON.stringify(excSCRX));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExcSCRXService.updateExcSCRX(excSCRX).then( res => {
            this.props.history.push('/excSCRXs');
        });
    }

    changecswitchHandler= (event) => {
        this.setState({cswitch: event.target.value});
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
    changercrfdHandler= (event) => {
        this.setState({rcrfd: event.target.value});
    }
    changetatbHandler= (event) => {
        this.setState({tatb: event.target.value});
    }
    changetbHandler= (event) => {
        this.setState({tb: event.target.value});
    }
    changeteHandler= (event) => {
        this.setState({te: event.target.value});
    }

    cancel(){
        this.props.history.push('/excSCRXs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExcSCRX</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> cswitch: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> emin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> k: </label>
                                            #formFields( $attribute, 'update')
                                            <label> rcrfd: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tatb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tb: </label>
                                            #formFields( $attribute, 'update')
                                            <label> te: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExcSCRX}>Save</button>
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

export default UpdateExcSCRXComponent
