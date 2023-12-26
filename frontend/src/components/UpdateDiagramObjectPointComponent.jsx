import React, { Component } from 'react'
import DiagramObjectPointService from '../services/DiagramObjectPointService';

class UpdateDiagramObjectPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                sequenceNumber: '',
                xPosition: '',
                yPosition: '',
                zPosition: ''
        }
        this.updateDiagramObjectPoint = this.updateDiagramObjectPoint.bind(this);

        this.changesequenceNumberHandler = this.changesequenceNumberHandler.bind(this);
        this.changexPositionHandler = this.changexPositionHandler.bind(this);
        this.changeyPositionHandler = this.changeyPositionHandler.bind(this);
        this.changezPositionHandler = this.changezPositionHandler.bind(this);
    }

    componentDidMount(){
        DiagramObjectPointService.getDiagramObjectPointById(this.state.id).then( (res) =>{
            let diagramObjectPoint = res.data;
            this.setState({
                sequenceNumber: diagramObjectPoint.sequenceNumber,
                xPosition: diagramObjectPoint.xPosition,
                yPosition: diagramObjectPoint.yPosition,
                zPosition: diagramObjectPoint.zPosition
            });
        });
    }

    updateDiagramObjectPoint = (e) => {
        e.preventDefault();
        let diagramObjectPoint = {
            diagramObjectPointId: this.state.id,
            sequenceNumber: this.state.sequenceNumber,
            xPosition: this.state.xPosition,
            yPosition: this.state.yPosition,
            zPosition: this.state.zPosition
        };
        console.log('diagramObjectPoint => ' + JSON.stringify(diagramObjectPoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramObjectPointService.updateDiagramObjectPoint(diagramObjectPoint).then( res => {
            this.props.history.push('/diagramObjectPoints');
        });
    }

    changesequenceNumberHandler= (event) => {
        this.setState({sequenceNumber: event.target.value});
    }
    changexPositionHandler= (event) => {
        this.setState({xPosition: event.target.value});
    }
    changeyPositionHandler= (event) => {
        this.setState({yPosition: event.target.value});
    }
    changezPositionHandler= (event) => {
        this.setState({zPosition: event.target.value});
    }

    cancel(){
        this.props.history.push('/diagramObjectPoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiagramObjectPoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> sequenceNumber: </label>
                                            #formFields( $attribute, 'update')
                                            <label> xPosition: </label>
                                            #formFields( $attribute, 'update')
                                            <label> yPosition: </label>
                                            #formFields( $attribute, 'update')
                                            <label> zPosition: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagramObjectPoint}>Save</button>
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

export default UpdateDiagramObjectPointComponent
