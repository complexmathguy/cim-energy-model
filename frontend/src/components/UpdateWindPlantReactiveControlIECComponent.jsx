import React, { Component } from 'react'
import WindPlantReactiveControlIECService from '../services/WindPlantReactiveControlIECService';

class UpdateWindPlantReactiveControlIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                kiwpx: '',
                kpwpx: '',
                kwpqu: '',
                mwppf: '',
                mwpu: '',
                twppfilt: '',
                twpqfilt: '',
                twpufilt: '',
                txft: '',
                txfv: '',
                uwpqdip: '',
                xrefmax: '',
                xrefmin: ''
        }
        this.updateWindPlantReactiveControlIEC = this.updateWindPlantReactiveControlIEC.bind(this);

        this.changekiwpxHandler = this.changekiwpxHandler.bind(this);
        this.changekpwpxHandler = this.changekpwpxHandler.bind(this);
        this.changekwpquHandler = this.changekwpquHandler.bind(this);
        this.changemwppfHandler = this.changemwppfHandler.bind(this);
        this.changemwpuHandler = this.changemwpuHandler.bind(this);
        this.changetwppfiltHandler = this.changetwppfiltHandler.bind(this);
        this.changetwpqfiltHandler = this.changetwpqfiltHandler.bind(this);
        this.changetwpufiltHandler = this.changetwpufiltHandler.bind(this);
        this.changetxftHandler = this.changetxftHandler.bind(this);
        this.changetxfvHandler = this.changetxfvHandler.bind(this);
        this.changeuwpqdipHandler = this.changeuwpqdipHandler.bind(this);
        this.changexrefmaxHandler = this.changexrefmaxHandler.bind(this);
        this.changexrefminHandler = this.changexrefminHandler.bind(this);
    }

    componentDidMount(){
        WindPlantReactiveControlIECService.getWindPlantReactiveControlIECById(this.state.id).then( (res) =>{
            let windPlantReactiveControlIEC = res.data;
            this.setState({
                kiwpx: windPlantReactiveControlIEC.kiwpx,
                kpwpx: windPlantReactiveControlIEC.kpwpx,
                kwpqu: windPlantReactiveControlIEC.kwpqu,
                mwppf: windPlantReactiveControlIEC.mwppf,
                mwpu: windPlantReactiveControlIEC.mwpu,
                twppfilt: windPlantReactiveControlIEC.twppfilt,
                twpqfilt: windPlantReactiveControlIEC.twpqfilt,
                twpufilt: windPlantReactiveControlIEC.twpufilt,
                txft: windPlantReactiveControlIEC.txft,
                txfv: windPlantReactiveControlIEC.txfv,
                uwpqdip: windPlantReactiveControlIEC.uwpqdip,
                xrefmax: windPlantReactiveControlIEC.xrefmax,
                xrefmin: windPlantReactiveControlIEC.xrefmin
            });
        });
    }

    updateWindPlantReactiveControlIEC = (e) => {
        e.preventDefault();
        let windPlantReactiveControlIEC = {
            windPlantReactiveControlIECId: this.state.id,
            kiwpx: this.state.kiwpx,
            kpwpx: this.state.kpwpx,
            kwpqu: this.state.kwpqu,
            mwppf: this.state.mwppf,
            mwpu: this.state.mwpu,
            twppfilt: this.state.twppfilt,
            twpqfilt: this.state.twpqfilt,
            twpufilt: this.state.twpufilt,
            txft: this.state.txft,
            txfv: this.state.txfv,
            uwpqdip: this.state.uwpqdip,
            xrefmax: this.state.xrefmax,
            xrefmin: this.state.xrefmin
        };
        console.log('windPlantReactiveControlIEC => ' + JSON.stringify(windPlantReactiveControlIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindPlantReactiveControlIECService.updateWindPlantReactiveControlIEC(windPlantReactiveControlIEC).then( res => {
            this.props.history.push('/windPlantReactiveControlIECs');
        });
    }

    changekiwpxHandler= (event) => {
        this.setState({kiwpx: event.target.value});
    }
    changekpwpxHandler= (event) => {
        this.setState({kpwpx: event.target.value});
    }
    changekwpquHandler= (event) => {
        this.setState({kwpqu: event.target.value});
    }
    changemwppfHandler= (event) => {
        this.setState({mwppf: event.target.value});
    }
    changemwpuHandler= (event) => {
        this.setState({mwpu: event.target.value});
    }
    changetwppfiltHandler= (event) => {
        this.setState({twppfilt: event.target.value});
    }
    changetwpqfiltHandler= (event) => {
        this.setState({twpqfilt: event.target.value});
    }
    changetwpufiltHandler= (event) => {
        this.setState({twpufilt: event.target.value});
    }
    changetxftHandler= (event) => {
        this.setState({txft: event.target.value});
    }
    changetxfvHandler= (event) => {
        this.setState({txfv: event.target.value});
    }
    changeuwpqdipHandler= (event) => {
        this.setState({uwpqdip: event.target.value});
    }
    changexrefmaxHandler= (event) => {
        this.setState({xrefmax: event.target.value});
    }
    changexrefminHandler= (event) => {
        this.setState({xrefmin: event.target.value});
    }

    cancel(){
        this.props.history.push('/windPlantReactiveControlIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindPlantReactiveControlIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> kiwpx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kpwpx: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kwpqu: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwppf: </label>
                                            #formFields( $attribute, 'update')
                                            <label> mwpu: </label>
                                            #formFields( $attribute, 'update')
                                            <label> twppfilt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> twpqfilt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> twpufilt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> txft: </label>
                                            #formFields( $attribute, 'update')
                                            <label> txfv: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uwpqdip: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xrefmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xrefmin: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindPlantReactiveControlIEC}>Save</button>
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

export default UpdateWindPlantReactiveControlIECComponent
