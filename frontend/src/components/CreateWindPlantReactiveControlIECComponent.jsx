import React, { Component } from 'react'
import WindPlantReactiveControlIECService from '../services/WindPlantReactiveControlIECService';

class CreateWindPlantReactiveControlIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
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

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateWindPlantReactiveControlIEC = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            windPlantReactiveControlIEC.windPlantReactiveControlIECId=''
            WindPlantReactiveControlIECService.createWindPlantReactiveControlIEC(windPlantReactiveControlIEC).then(res =>{
                this.props.history.push('/windPlantReactiveControlIECs');
            });
        }else{
            WindPlantReactiveControlIECService.updateWindPlantReactiveControlIEC(windPlantReactiveControlIEC).then( res => {
                this.props.history.push('/windPlantReactiveControlIECs');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindPlantReactiveControlIEC</h3>
        }else{
            return <h3 className="text-center">Update WindPlantReactiveControlIEC</h3>
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
                                            <label> kiwpx: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpwpx: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kwpqu: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwppf: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mwpu: </label>
                                            #formFields( $attribute, 'create')
                                            <label> twppfilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> twpqfilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> twpufilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> txft: </label>
                                            #formFields( $attribute, 'create')
                                            <label> txfv: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uwpqdip: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xrefmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xrefmin: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindPlantReactiveControlIEC}>Save</button>
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

export default CreateWindPlantReactiveControlIECComponent
