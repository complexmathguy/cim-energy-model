import React, { Component } from 'react'
import WindContPType3IECService from '../services/WindContPType3IECService';

class CreateWindContPType3IECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                dpmax: '',
                dtrisemaxlvrt: '',
                kdtd: '',
                kip: '',
                kpp: '',
                mplvrt: '',
                omegaoffset: '',
                pdtdmax: '',
                rramp: '',
                tdvs: '',
                temin: '',
                tomegafilt: '',
                tpfilt: '',
                tpord: '',
                tufilt: '',
                tuscale: '',
                twref: '',
                udvs: '',
                updip: '',
                wdtd: '',
                zeta: ''
        }
        this.changedpmaxHandler = this.changedpmaxHandler.bind(this);
        this.changedtrisemaxlvrtHandler = this.changedtrisemaxlvrtHandler.bind(this);
        this.changekdtdHandler = this.changekdtdHandler.bind(this);
        this.changekipHandler = this.changekipHandler.bind(this);
        this.changekppHandler = this.changekppHandler.bind(this);
        this.changemplvrtHandler = this.changemplvrtHandler.bind(this);
        this.changeomegaoffsetHandler = this.changeomegaoffsetHandler.bind(this);
        this.changepdtdmaxHandler = this.changepdtdmaxHandler.bind(this);
        this.changerrampHandler = this.changerrampHandler.bind(this);
        this.changetdvsHandler = this.changetdvsHandler.bind(this);
        this.changeteminHandler = this.changeteminHandler.bind(this);
        this.changetomegafiltHandler = this.changetomegafiltHandler.bind(this);
        this.changetpfiltHandler = this.changetpfiltHandler.bind(this);
        this.changetpordHandler = this.changetpordHandler.bind(this);
        this.changetufiltHandler = this.changetufiltHandler.bind(this);
        this.changetuscaleHandler = this.changetuscaleHandler.bind(this);
        this.changetwrefHandler = this.changetwrefHandler.bind(this);
        this.changeudvsHandler = this.changeudvsHandler.bind(this);
        this.changeupdipHandler = this.changeupdipHandler.bind(this);
        this.changewdtdHandler = this.changewdtdHandler.bind(this);
        this.changezetaHandler = this.changezetaHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindContPType3IECService.getWindContPType3IECById(this.state.id).then( (res) =>{
                let windContPType3IEC = res.data;
                this.setState({
                    dpmax: windContPType3IEC.dpmax,
                    dtrisemaxlvrt: windContPType3IEC.dtrisemaxlvrt,
                    kdtd: windContPType3IEC.kdtd,
                    kip: windContPType3IEC.kip,
                    kpp: windContPType3IEC.kpp,
                    mplvrt: windContPType3IEC.mplvrt,
                    omegaoffset: windContPType3IEC.omegaoffset,
                    pdtdmax: windContPType3IEC.pdtdmax,
                    rramp: windContPType3IEC.rramp,
                    tdvs: windContPType3IEC.tdvs,
                    temin: windContPType3IEC.temin,
                    tomegafilt: windContPType3IEC.tomegafilt,
                    tpfilt: windContPType3IEC.tpfilt,
                    tpord: windContPType3IEC.tpord,
                    tufilt: windContPType3IEC.tufilt,
                    tuscale: windContPType3IEC.tuscale,
                    twref: windContPType3IEC.twref,
                    udvs: windContPType3IEC.udvs,
                    updip: windContPType3IEC.updip,
                    wdtd: windContPType3IEC.wdtd,
                    zeta: windContPType3IEC.zeta
                });
            });
        }        
    }
    saveOrUpdateWindContPType3IEC = (e) => {
        e.preventDefault();
        let windContPType3IEC = {
                windContPType3IECId: this.state.id,
                dpmax: this.state.dpmax,
                dtrisemaxlvrt: this.state.dtrisemaxlvrt,
                kdtd: this.state.kdtd,
                kip: this.state.kip,
                kpp: this.state.kpp,
                mplvrt: this.state.mplvrt,
                omegaoffset: this.state.omegaoffset,
                pdtdmax: this.state.pdtdmax,
                rramp: this.state.rramp,
                tdvs: this.state.tdvs,
                temin: this.state.temin,
                tomegafilt: this.state.tomegafilt,
                tpfilt: this.state.tpfilt,
                tpord: this.state.tpord,
                tufilt: this.state.tufilt,
                tuscale: this.state.tuscale,
                twref: this.state.twref,
                udvs: this.state.udvs,
                updip: this.state.updip,
                wdtd: this.state.wdtd,
                zeta: this.state.zeta
            };
        console.log('windContPType3IEC => ' + JSON.stringify(windContPType3IEC));

        // step 5
        if(this.state.id === '_add'){
            windContPType3IEC.windContPType3IECId=''
            WindContPType3IECService.createWindContPType3IEC(windContPType3IEC).then(res =>{
                this.props.history.push('/windContPType3IECs');
            });
        }else{
            WindContPType3IECService.updateWindContPType3IEC(windContPType3IEC).then( res => {
                this.props.history.push('/windContPType3IECs');
            });
        }
    }
    
    changedpmaxHandler= (event) => {
        this.setState({dpmax: event.target.value});
    }
    changedtrisemaxlvrtHandler= (event) => {
        this.setState({dtrisemaxlvrt: event.target.value});
    }
    changekdtdHandler= (event) => {
        this.setState({kdtd: event.target.value});
    }
    changekipHandler= (event) => {
        this.setState({kip: event.target.value});
    }
    changekppHandler= (event) => {
        this.setState({kpp: event.target.value});
    }
    changemplvrtHandler= (event) => {
        this.setState({mplvrt: event.target.value});
    }
    changeomegaoffsetHandler= (event) => {
        this.setState({omegaoffset: event.target.value});
    }
    changepdtdmaxHandler= (event) => {
        this.setState({pdtdmax: event.target.value});
    }
    changerrampHandler= (event) => {
        this.setState({rramp: event.target.value});
    }
    changetdvsHandler= (event) => {
        this.setState({tdvs: event.target.value});
    }
    changeteminHandler= (event) => {
        this.setState({temin: event.target.value});
    }
    changetomegafiltHandler= (event) => {
        this.setState({tomegafilt: event.target.value});
    }
    changetpfiltHandler= (event) => {
        this.setState({tpfilt: event.target.value});
    }
    changetpordHandler= (event) => {
        this.setState({tpord: event.target.value});
    }
    changetufiltHandler= (event) => {
        this.setState({tufilt: event.target.value});
    }
    changetuscaleHandler= (event) => {
        this.setState({tuscale: event.target.value});
    }
    changetwrefHandler= (event) => {
        this.setState({twref: event.target.value});
    }
    changeudvsHandler= (event) => {
        this.setState({udvs: event.target.value});
    }
    changeupdipHandler= (event) => {
        this.setState({updip: event.target.value});
    }
    changewdtdHandler= (event) => {
        this.setState({wdtd: event.target.value});
    }
    changezetaHandler= (event) => {
        this.setState({zeta: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContPType3IECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContPType3IEC</h3>
        }else{
            return <h3 className="text-center">Update WindContPType3IEC</h3>
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
                                            <label> dpmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> dtrisemaxlvrt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kdtd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kip: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> mplvrt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> omegaoffset: </label>
                                            #formFields( $attribute, 'create')
                                            <label> pdtdmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rramp: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tdvs: </label>
                                            #formFields( $attribute, 'create')
                                            <label> temin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tomegafilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpfilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpord: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tufilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tuscale: </label>
                                            #formFields( $attribute, 'create')
                                            <label> twref: </label>
                                            #formFields( $attribute, 'create')
                                            <label> udvs: </label>
                                            #formFields( $attribute, 'create')
                                            <label> updip: </label>
                                            #formFields( $attribute, 'create')
                                            <label> wdtd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> zeta: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContPType3IEC}>Save</button>
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

export default CreateWindContPType3IECComponent
