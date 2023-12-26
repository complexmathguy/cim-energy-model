import React, { Component } from 'react'
import DiagramObjectGluePointService from '../services/DiagramObjectGluePointService';

class CreateDiagramObjectGluePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            DiagramObjectGluePointService.getDiagramObjectGluePointById(this.state.id).then( (res) =>{
                let diagramObjectGluePoint = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiagramObjectGluePoint = (e) => {
        e.preventDefault();
        let diagramObjectGluePoint = {
                diagramObjectGluePointId: this.state.id,
            };
        console.log('diagramObjectGluePoint => ' + JSON.stringify(diagramObjectGluePoint));

        // step 5
        if(this.state.id === '_add'){
            diagramObjectGluePoint.diagramObjectGluePointId=''
            DiagramObjectGluePointService.createDiagramObjectGluePoint(diagramObjectGluePoint).then(res =>{
                this.props.history.push('/diagramObjectGluePoints');
            });
        }else{
            DiagramObjectGluePointService.updateDiagramObjectGluePoint(diagramObjectGluePoint).then( res => {
                this.props.history.push('/diagramObjectGluePoints');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/diagramObjectGluePoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramObjectGluePoint</h3>
        }else{
            return <h3 className="text-center">Update DiagramObjectGluePoint</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramObjectGluePoint}>Save</button>
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

export default CreateDiagramObjectGluePointComponent
