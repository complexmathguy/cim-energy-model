import React, { Component } from 'react'
import WindPlantFreqPcontrolIECService from '../services/WindPlantFreqPcontrolIECService';

class UpdateWindPlantFreqPcontrolIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dprefmax: '',
                dprefmin: '',
                kiwpp: '',
                kpwpp: '',
                prefmax: '',
                prefmin: '',
                tpft: '',
                tpfv: '',
                twpffilt: '',
                twppfilt: ''
        }
        this.updateWindPlantFreqPcontrolIEC = this.updateWindPlantFreqPcontrolIEC.bind(this);

        this.changedprefmaxHandler = this.changedprefmaxHandler.bind(this);
        this.changedprefminHandler = this.changedprefminHandler.bind(this);
        this.changekiwppHandler = this.changekiwppHandler.bind(this);
        this.changekpwppHandler = this.changekpwppHandler.bind(this);
        this.changeprefmaxHandler = this.changeprefmaxHandler.bind(this);
        this.changeprefminHandler = this.changeprefminHandler.bind(this);
        this.changetpftHandler = this.changetpftHandler.bind(this);
        this.changetpfvHandler = this.changetpfvHandler.bind(this);
        this.changetwpffiltHandler = this.changetwpffiltHandler.bind(this);
        this.changetwppfiltHandler = this.changetwppfiltHandler.bind(this);
    }

    componentDidMount(){
        WindPlantFreqPcontrolIECService.getWindPlantFreqPcontrolIECById(this.state.id).then( (res) =>{
            let windPlantFreqPcontrolIEC = res.data;
            this.setState({
                dprefmax: windPlantFreqPcontrolIEC.dprefmax,
                dprefmin: windPlantFreqPcontrolIEC.dprefmin,
                kiwpp: windPlantFreqPcontrolIEC.kiwpp,
                kpwpp: windPlantFreqPcontrolIEC.kpwpp,
                prefmax: windPlantFreqPcontrolIEC.prefmax,
                prefmin: windPlantFreqPcontrolIEC.prefmin,
                tpft: windPlantFreqPcontrolIEC.tpft,
                tpfv: windPlantFreqPcontrolIEC.tpfv,
                twpffilt: windPlantFreqPcontrolIEC.twpffilt,
                twppfilt: windPlantFreqPcontrolIEC.twppfilt
            });
        });
    }

    updateWindPlantFreqPcontrolIEC = (e) => {
        e.preventDefault();
        let windPlantFreqPcontrolIEC = {
            windPlantFreqPcontrolIECId: this.state.id,
            dprefmax: this.state.dprefmax,
            dprefmin: this.state.dprefmin,
            kiwpp: this.state.kiwpp,
            kpwpp: this.state.kpwpp,
            prefmax: this.state.prefmax,
            prefmin: this.state.prefmin,
            tpft: this.state.tpft,
            tpfv: this.state.tpfv,
            twpffilt: this.state.twpffilt,
            twppfilt: this.state.twppfilt
        };
        console.log('windPlantFreqPcontrolIEC => ' + JSON.stringify(windPlantFreqPcontrolIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPlantFreqPcontrolIECService.updateWindPlantFreqPcontrolIEC(windPlantFreqPcontrolIEC).then( res => {
            this.props.history.push('/windPlantFreqPcontrolIECs');
        });
    }

    changedprefmaxHandler= (event) => {
        this.setState({dprefmax: event.target.value});
    }
    changedprefminHandler= (event) => {
        this.setState({dprefmin: event.target.value});
    }
    changekiwppHandler= (event) => {
        this.setState({kiwpp: event.target.value});
    }
    changekpwppHandler= (event) => {
        this.setState({kpwpp: event.target.value});
    }
    changeprefmaxHandler= (event) => {
        this.setState({prefmax: event.target.value});
    }
    changeprefminHandler= (event) => {
        this.setState({prefmin: event.target.value});
    }
    changetpftHandler= (event) => {
        this.setState({tpft: event.target.value});
    }
    changetpfvHandler= (event) => {
        this.setState({tpfv: event.target.value});
    }
    changetwpffiltHandler= (event) => {
        this.setState({twpffilt: event.target.value});
    }
    changetwppfiltHandler= (event) => {
        this.setState({twppfilt: event.target.value});
    }

    cancel(){
        this.props.history.push('/windPlantFreqPcontrolIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPlantFreqPcontrolIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dprefmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> dprefmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kiwpp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpwpp: </label>
                                            #formFields( $attribute, 'update')
                                            <label> prefmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> prefmin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpft: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpfv: </label>
                                            #formFields( $attribute, 'update')
                                            <label> twpffilt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> twppfilt: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPlantFreqPcontrolIEC}>Save</button>
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

export default UpdateWindPlantFreqPcontrolIECComponent
