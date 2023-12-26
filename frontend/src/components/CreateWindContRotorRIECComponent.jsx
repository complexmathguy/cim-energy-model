import React, { Component } from 'react'
import WindContRotorRIECService from '../services/WindContRotorRIECService';

class CreateWindContRotorRIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                kirr: '',
                komegafilt: '',
                kpfilt: '',
                kprr: '',
                rmax: '',
                rmin: '',
                tomegafilt: '',
                tpfilt: ''
        }
        this.changekirrHandler = this.changekirrHandler.bind(this);
        this.changekomegafiltHandler = this.changekomegafiltHandler.bind(this);
        this.changekpfiltHandler = this.changekpfiltHandler.bind(this);
        this.changekprrHandler = this.changekprrHandler.bind(this);
        this.changermaxHandler = this.changermaxHandler.bind(this);
        this.changerminHandler = this.changerminHandler.bind(this);
        this.changetomegafiltHandler = this.changetomegafiltHandler.bind(this);
        this.changetpfiltHandler = this.changetpfiltHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            WindContRotorRIECService.getWindContRotorRIECById(this.state.id).then( (res) =>{
                let windContRotorRIEC = res.data;
                this.setState({
                    kirr: windContRotorRIEC.kirr,
                    komegafilt: windContRotorRIEC.komegafilt,
                    kpfilt: windContRotorRIEC.kpfilt,
                    kprr: windContRotorRIEC.kprr,
                    rmax: windContRotorRIEC.rmax,
                    rmin: windContRotorRIEC.rmin,
                    tomegafilt: windContRotorRIEC.tomegafilt,
                    tpfilt: windContRotorRIEC.tpfilt
                });
            });
        }        
    }
    saveOrUpdateWindContRotorRIEC = (e) => {
        e.preventDefault();
        let windContRotorRIEC = {
                windContRotorRIECId: this.state.id,
                kirr: this.state.kirr,
                komegafilt: this.state.komegafilt,
                kpfilt: this.state.kpfilt,
                kprr: this.state.kprr,
                rmax: this.state.rmax,
                rmin: this.state.rmin,
                tomegafilt: this.state.tomegafilt,
                tpfilt: this.state.tpfilt
            };
        console.log('windContRotorRIEC => ' + JSON.stringify(windContRotorRIEC));

        // step 5
        if(this.state.id === '_add'){
            windContRotorRIEC.windContRotorRIECId=''
            WindContRotorRIECService.createWindContRotorRIEC(windContRotorRIEC).then(res =>{
                this.props.history.push('/windContRotorRIECs');
            });
        }else{
            WindContRotorRIECService.updateWindContRotorRIEC(windContRotorRIEC).then( res => {
                this.props.history.push('/windContRotorRIECs');
            });
        }
    }
    
    changekirrHandler= (event) => {
        this.setState({kirr: event.target.value});
    }
    changekomegafiltHandler= (event) => {
        this.setState({komegafilt: event.target.value});
    }
    changekpfiltHandler= (event) => {
        this.setState({kpfilt: event.target.value});
    }
    changekprrHandler= (event) => {
        this.setState({kprr: event.target.value});
    }
    changermaxHandler= (event) => {
        this.setState({rmax: event.target.value});
    }
    changerminHandler= (event) => {
        this.setState({rmin: event.target.value});
    }
    changetomegafiltHandler= (event) => {
        this.setState({tomegafilt: event.target.value});
    }
    changetpfiltHandler= (event) => {
        this.setState({tpfilt: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContRotorRIECs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindContRotorRIEC</h3>
        }else{
            return <h3 className="text-center">Update WindContRotorRIEC</h3>
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
                                            <label> kirr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> komegafilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kpfilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kprr: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> rmin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tomegafilt: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tpfilt: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindContRotorRIEC}>Save</button>
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

export default CreateWindContRotorRIECComponent
