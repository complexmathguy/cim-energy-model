import React, { Component } from 'react'
import DiagramStyleService from '../services/DiagramStyleService';

class UpdateDiagramStyleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiagramStyle = this.updateDiagramStyle.bind(this);

    }

    componentDidMount(){
        DiagramStyleService.getDiagramStyleById(this.state.id).then( (res) =>{
            let diagramStyle = res.data;
            this.setState({
            });
        });
    }

    updateDiagramStyle = (e) => {
        e.preventDefault();
        let diagramStyle = {
            diagramStyleId: this.state.id,
        };
        console.log('diagramStyle => ' + JSON.stringify(diagramStyle));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramStyleService.updateDiagramStyle(diagramStyle).then( res => {
            this.props.history.push('/diagramStyles');
        });
    }


    cancel(){
        this.props.history.push('/diagramStyles');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiagramStyle</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagramStyle}>Save</button>
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

export default UpdateDiagramStyleComponent
