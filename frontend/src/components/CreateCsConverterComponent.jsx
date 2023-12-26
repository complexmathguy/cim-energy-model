import React, { Component } from 'react'
import CsConverterService from '../services/CsConverterService';

class CreateCsConverterComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                maxAlpha: '',
                maxGamma: '',
                maxIdc: '',
                minAlpha: '',
                minGamma: '',
                minIdc: '',
                ratedIdc: ''
        }
        this.changemaxAlphaHandler = this.changemaxAlphaHandler.bind(this);
        this.changemaxGammaHandler = this.changemaxGammaHandler.bind(this);
        this.changemaxIdcHandler = this.changemaxIdcHandler.bind(this);
        this.changeminAlphaHandler = this.changeminAlphaHandler.bind(this);
        this.changeminGammaHandler = this.changeminGammaHandler.bind(this);
        this.changeminIdcHandler = this.changeminIdcHandler.bind(this);
        this.changeratedIdcHandler = this.changeratedIdcHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            CsConverterService.getCsConverterById(this.state.id).then( (res) =>{
                let csConverter = res.data;
                this.setState({
                    maxAlpha: csConverter.maxAlpha,
                    maxGamma: csConverter.maxGamma,
                    maxIdc: csConverter.maxIdc,
                    minAlpha: csConverter.minAlpha,
                    minGamma: csConverter.minGamma,
                    minIdc: csConverter.minIdc,
                    ratedIdc: csConverter.ratedIdc
                });
            });
        }        
    }
    saveOrUpdateCsConverter = (e) => {
        e.preventDefault();
        let csConverter = {
                csConverterId: this.state.id,
                maxAlpha: this.state.maxAlpha,
                maxGamma: this.state.maxGamma,
                maxIdc: this.state.maxIdc,
                minAlpha: this.state.minAlpha,
                minGamma: this.state.minGamma,
                minIdc: this.state.minIdc,
                ratedIdc: this.state.ratedIdc
            };
        console.log('csConverter => ' + JSON.stringify(csConverter));

        // step 5
        if(this.state.id === '_add'){
            csConverter.csConverterId=''
            CsConverterService.createCsConverter(csConverter).then(res =>{
                this.props.history.push('/csConverters');
            });
        }else{
            CsConverterService.updateCsConverter(csConverter).then( res => {
                this.props.history.push('/csConverters');
            });
        }
    }
    
    changemaxAlphaHandler= (event) => {
        this.setState({maxAlpha: event.target.value});
    }
    changemaxGammaHandler= (event) => {
        this.setState({maxGamma: event.target.value});
    }
    changemaxIdcHandler= (event) => {
        this.setState({maxIdc: event.target.value});
    }
    changeminAlphaHandler= (event) => {
        this.setState({minAlpha: event.target.value});
    }
    changeminGammaHandler= (event) => {
        this.setState({minGamma: event.target.value});
    }
    changeminIdcHandler= (event) => {
        this.setState({minIdc: event.target.value});
    }
    changeratedIdcHandler= (event) => {
        this.setState({ratedIdc: event.target.value});
    }

    cancel(){
        this.props.history.push('/csConverters');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add CsConverter</h3>
        }else{
            return <h3 className="text-center">Update CsConverter</h3>
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
                                            <label> maxAlpha: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxGamma: </label>
                                            #formFields( $attribute, 'create')
                                            <label> maxIdc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minAlpha: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minGamma: </label>
                                            #formFields( $attribute, 'create')
                                            <label> minIdc: </label>
                                            #formFields( $attribute, 'create')
                                            <label> ratedIdc: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateCsConverter}>Save</button>
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

export default CreateCsConverterComponent
