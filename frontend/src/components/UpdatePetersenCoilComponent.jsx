import React, { Component } from 'react'
import PetersenCoilService from '../services/PetersenCoilService';

class UpdatePetersenCoilComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                mode: '',
                nominalU: '',
                offsetCurrent: '',
                positionCurrent: '',
                xGroundMax: '',
                xGroundMin: '',
                xGroundNominal: ''
        }
        this.updatePetersenCoil = this.updatePetersenCoil.bind(this);

        this.changemodeHandler = this.changemodeHandler.bind(this);
        this.changenominalUHandler = this.changenominalUHandler.bind(this);
        this.changeoffsetCurrentHandler = this.changeoffsetCurrentHandler.bind(this);
        this.changepositionCurrentHandler = this.changepositionCurrentHandler.bind(this);
        this.changexGroundMaxHandler = this.changexGroundMaxHandler.bind(this);
        this.changexGroundMinHandler = this.changexGroundMinHandler.bind(this);
        this.changexGroundNominalHandler = this.changexGroundNominalHandler.bind(this);
    }

    componentDidMount(){
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

    updatePetersenCoil = (e) => {
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
        console.log('id => ' + JSON.stringify(this.state.id));
        PetersenCoilService.updatePetersenCoil(petersenCoil).then( res => {
            this.props.history.push('/petersenCoils');
        });
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

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PetersenCoil</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> mode: </label>
                                            #formFields( $attribute, 'update')
                                            <label> nominalU: </label>
                                            #formFields( $attribute, 'update')
                                            <label> offsetCurrent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> positionCurrent: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xGroundMax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xGroundMin: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xGroundNominal: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePetersenCoil}>Save</button>
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

export default UpdatePetersenCoilComponent
