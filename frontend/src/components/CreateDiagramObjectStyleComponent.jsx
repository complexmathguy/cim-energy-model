import React, { Component } from 'react'
import DiagramObjectStyleService from '../services/DiagramObjectStyleService';

class CreateDiagramObjectStyleComponent extends Component {
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
            DiagramObjectStyleService.getDiagramObjectStyleById(this.state.id).then( (res) =>{
                let diagramObjectStyle = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateDiagramObjectStyle = (e) => {
        e.preventDefault();
        let diagramObjectStyle = {
                diagramObjectStyleId: this.state.id,
            };
        console.log('diagramObjectStyle => ' + JSON.stringify(diagramObjectStyle));

        // step 5
        if(this.state.id === '_add'){
            diagramObjectStyle.diagramObjectStyleId=''
            DiagramObjectStyleService.createDiagramObjectStyle(diagramObjectStyle).then(res =>{
                this.props.history.push('/diagramObjectStyles');
            });
        }else{
            DiagramObjectStyleService.updateDiagramObjectStyle(diagramObjectStyle).then( res => {
                this.props.history.push('/diagramObjectStyles');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/diagramObjectStyles');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DiagramObjectStyle</h3>
        }else{
            return <h3 className="text-center">Update DiagramObjectStyle</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDiagramObjectStyle}>Save</button>
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

export default CreateDiagramObjectStyleComponent
