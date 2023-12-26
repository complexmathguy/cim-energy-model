import React, { Component } from 'react'
import OverexcLimIEEEService from '../services/OverexcLimIEEEService';

class CreateOverexcLimIEEEComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                hyst: '',
                ifdlim: '',
                ifdmax: '',
                itfpu: '',
                kcd: '',
                kramp: ''
        }
        this.changehystHandler = this.changehystHandler.bind(this);
        this.changeifdlimHandler = this.changeifdlimHandler.bind(this);
        this.changeifdmaxHandler = this.changeifdmaxHandler.bind(this);
        this.changeitfpuHandler = this.changeitfpuHandler.bind(this);
        this.changekcdHandler = this.changekcdHandler.bind(this);
        this.changekrampHandler = this.changekrampHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            OverexcLimIEEEService.getOverexcLimIEEEById(this.state.id).then( (res) =>{
                let overexcLimIEEE = res.data;
                this.setState({
                    hyst: overexcLimIEEE.hyst,
                    ifdlim: overexcLimIEEE.ifdlim,
                    ifdmax: overexcLimIEEE.ifdmax,
                    itfpu: overexcLimIEEE.itfpu,
                    kcd: overexcLimIEEE.kcd,
                    kramp: overexcLimIEEE.kramp
                });
            });
        }        
    }
    saveOrUpdateOverexcLimIEEE = (e) => {
        e.preventDefault();
        let overexcLimIEEE = {
                overexcLimIEEEId: this.state.id,
                hyst: this.state.hyst,
                ifdlim: this.state.ifdlim,
                ifdmax: this.state.ifdmax,
                itfpu: this.state.itfpu,
                kcd: this.state.kcd,
                kramp: this.state.kramp
            };
        console.log('overexcLimIEEE => ' + JSON.stringify(overexcLimIEEE));

        // step 5
        if(this.state.id === '_add'){
            overexcLimIEEE.overexcLimIEEEId=''
            OverexcLimIEEEService.createOverexcLimIEEE(overexcLimIEEE).then(res =>{
                this.props.history.push('/overexcLimIEEEs');
            });
        }else{
            OverexcLimIEEEService.updateOverexcLimIEEE(overexcLimIEEE).then( res => {
                this.props.history.push('/overexcLimIEEEs');
            });
        }
    }
    
    changehystHandler= (event) => {
        this.setState({hyst: event.target.value});
    }
    changeifdlimHandler= (event) => {
        this.setState({ifdlim: event.target.value});
    }
    changeifdmaxHandler= (event) => {
        this.setState({ifdmax: event.target.value});
    }
    changeitfpuHandler= (event) => {
        this.setState({itfpu: event.target.value});
    }
    changekcdHandler= (event) => {
        this.setState({kcd: event.target.value});
    }
    changekrampHandler= (event) => {
        this.setState({kramp: event.target.value});
    }

    cancel(){
        this.props.history.push('/overexcLimIEEEs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OverexcLimIEEE</h3>
        }else{
            return <h3 className="text-center">Update OverexcLimIEEE</h3>
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
                                            <label> hyst: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ifdlim: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ifdmax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> itfpu: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kcd: </label>
                                            #formFields( $attribute, 'create')
                                            <label> kramp: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOverexcLimIEEE}>Save</button>
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

export default CreateOverexcLimIEEEComponent
