import React, { Component } from 'react'
import DiagramObjectGluePointService from '../services/DiagramObjectGluePointService';

class UpdateDiagramObjectGluePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiagramObjectGluePoint = this.updateDiagramObjectGluePoint.bind(this);

    }

    componentDidMount(){
        DiagramObjectGluePointService.getDiagramObjectGluePointById(this.state.id).then( (res) =>{
            let diagramObjectGluePoint = res.data;
            this.setState({
            });
        });
    }

    updateDiagramObjectGluePoint = (e) => {
        e.preventDefault();
        let diagramObjectGluePoint = {
            diagramObjectGluePointId: this.state.id,
        };
        console.log('diagramObjectGluePoint => ' + JSON.stringify(diagramObjectGluePoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramObjectGluePointService.updateDiagramObjectGluePoint(diagramObjectGluePoint).then( res => {
            this.props.history.push('/diagramObjectGluePoints');
        });
    }


    cancel(){
        this.props.history.push('/diagramObjectGluePoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiagramObjectGluePoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagramObjectGluePoint}>Save</button>
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

export default UpdateDiagramObjectGluePointComponent
