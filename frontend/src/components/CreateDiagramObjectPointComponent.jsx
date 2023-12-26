import React, { Component } from 'react'
import DiagramObjectPointService from '../services/DiagramObjectPointService';

class CreateDiagramObjectPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                sequenceNumber: '',
                xPosition: '',
                yPosition: '',
                zPosition: ''
        }
        this.changesequenceNumberHandler = this.changesequenceNumberHandler.bind(this);
        this.changexPositionHandler = this.changexPositionHandler.bind(this);
        this.changeyPositionHandler = this.changeyPositionHandler.bind(this);
        this.changezPositionHandler = this.changezPositionHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateDiagramObjectPoint = (e) => {
        e.preventDefault();
        let diagramObjectPoint = {
                diagramObjectPointId: this.state.id,
                sequenceNumber: this.state.sequenceNumber,
                xPosition: this.state.xPosition,
                yPosition: this.state.yPosition,
                zPosition: this.state.zPosition
            };
        console.log('diagramObjectPoint => ' + JSON.stringify(diagramObjectPoint));

        // step 5
        if(this.state.id === '_add'){
            diagramObjectPoint.diagramObjectPointId=''
            DiagramObjectPointService.createDiagramObjectPoint(diagramObjectPoint).then(res =>{
                this.props.history.push('/diagramObjectPoints');
            });
        }else{
            DiagramObjectPointService.updateDiagramObjectPoint(diagramObjectPoint).then( res => {
                this.props.history.push('/diagramObjectPoints');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramObjectPoint</h3>
        }else{
            return <h3 className="text-center">Update DiagramObjectPoint</h3>
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
                                            <label> sequenceNumber: </label>
                                            #formFields( $attribute, 'create')
                                            <label> xPosition: </label>
                                            #formFields( $attribute, 'create')
                                            <label> yPosition: </label>
                                            #formFields( $attribute, 'create')
                                            <label> zPosition: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramObjectPoint}>Save</button>
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

export default CreateDiagramObjectPointComponent
