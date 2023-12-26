import React, { Component } from 'react'
import DiagramStyleService from '../services/DiagramStyleService';

class CreateDiagramStyleComponent extends Component {
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
            DiagramStyleService.getDiagramStyleById(this.state.id).then( (res) =>{
                let diagramStyle = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiagramStyle = (e) => {
        e.preventDefault();
        let diagramStyle = {
                diagramStyleId: this.state.id,
            };
        console.log('diagramStyle => ' + JSON.stringify(diagramStyle));

        // step 5
        if(this.state.id === '_add'){
            diagramStyle.diagramStyleId=''
            DiagramStyleService.createDiagramStyle(diagramStyle).then(res =>{
                this.props.history.push('/diagramStyles');
            });
        }else{
            DiagramStyleService.updateDiagramStyle(diagramStyle).then( res => {
                this.props.history.push('/diagramStyles');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/diagramStyles');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramStyle</h3>
        }else{
            return <h3 className="text-center">Update DiagramStyle</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramStyle}>Save</button>
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

export default CreateDiagramStyleComponent
