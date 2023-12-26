import React, { Component } from 'react'
import PetersenCoilService from '../services/PetersenCoilService';

class CreatePetersenCoilComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                mode: '',
                nominalU: '',
                offsetCurrent: '',
                positionCurrent: '',
                xGroundMax: '',
                xGroundMin: '',
                xGroundNominal: ''
        }
        this.changemodeHandler = this.changemodeHandler.bind(this);
        this.changenominalUHandler = this.changenominalUHandler.bind(this);
        this.changeoffsetCurrentHandler = this.changeoffsetCurrentHandler.bind(this);
        this.changepositionCurrentHandler = this.changepositionCurrentHandler.bind(this);
        this.changexGroundMaxHandler = this.changexGroundMaxHandler.bind(this);
        this.changexGroundMinHandler = this.changexGroundMinHandler.bind(this);
        this.changexGroundNominalHandler = this.changexGroundNominalHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PetersenCoilService.getPetersenCoilById(this.state.id).then( (res) =>{
                let petersenCoil = res.data;
                this.setState({
                    mode: petersenCoil.mode,
                    nominalU: petersenCoil.nominalU,
                    offsetCurrent: petersenCoil.offsetCurrent,
                    positionCurrent: petersenCoil.positionCurrent,
                    xGroundMax: petersenCoil.xGroundMax,
                    xGroundMin: petersenCoil.xGroundMin,
                    xGroundNominal: petersenCoil.xGroundNominal
                });
            });
        }        
    }
    saveOrUpdatePetersenCoil = (e) => {
        e.preventDefault();
        let petersenCoil = {
                petersenCoilId: this.state.id,
                mode: this.state.mode,
                nominalU: this.state.nominalU,
                offsetCurrent: this.state.offsetCurrent,
                positionCurrent: this.state.positionCurrent,
                xGroundMax: this.state.xGroundMax,
                xGroundMin: this.state.xGroundMin,
                xGroundNominal: this.state.xGroundNominal
            };
        console.log('petersenCoil => ' + JSON.stringify(petersenCoil));

        // step 5
        if(this.state.id === '_add'){
            petersenCoil.petersenCoilId=''
            PetersenCoilService.createPetersenCoil(petersenCoil).then(res =>{
                this.props.history.push('/petersenCoils');
            });
        }else{
            PetersenCoilService.updatePetersenCoil(petersenCoil).then( res => {
                this.props.history.push('/petersenCoils');
            });
        }
    }
    
    changemodeHandler= (event) => {
        this.setState({mode: event.target.value});
    }
    changenominalUHandler= (event) => {
        this.setState({nominalU: event.target.value});
    }
    changeoffsetCurrentHandler= (event) => {
        this.setState({offsetCurrent: event.target.value});
    }
    changepositionCurrentHandler= (event) => {
        this.setState({positionCurrent: event.target.value});
    }
    changexGroundMaxHandler= (event) => {
        this.setState({xGroundMax: event.target.value});
    }
    changexGroundMinHandler= (event) => {
        this.setState({xGroundMin: event.target.value});
    }
    changexGroundNominalHandler= (event) => {
        this.setState({xGroundNominal: event.target.value});
    }

    cancel(){
        this.props.history.push('/petersenCoils');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PetersenCoil</h3>
        }else{
            return <h3 className="text-center">Update PetersenCoil</h3>
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
                                            <label> mode: </label>
                                            #formFields( $attribute, 'create')
                                            <label> nominalU: </label>
                                            #formFields( $attribute, 'create')
                                            <label> offsetCurrent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> positionCurrent: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xGroundMax: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xGroundMin: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xGroundNominal: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePetersenCoil}>Save</button>
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

export default CreatePetersenCoilComponent
