import React, { Component } from 'react'
import DiagramObjectStyleService from '../services/DiagramObjectStyleService';

class UpdateDiagramObjectStyleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDiagramObjectStyle = this.updateDiagramObjectStyle.bind(this);

    }

    componentDidMount(){
        DiagramObjectStyleService.getDiagramObjectStyleById(this.state.id).then( (res) =>{
            let diagramObjectStyle = res.data;
            this.setState({
            });
        });
    }

    updateDiagramObjectStyle = (e) => {
        e.preventDefault();
        let diagramObjectStyle = {
            diagramObjectStyleId: this.state.id,
        };
        console.log('diagramObjectStyle => ' + JSON.stringify(diagramObjectStyle));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramObjectStyleService.updateDiagramObjectStyle(diagramObjectStyle).then( res => {
            this.props.history.push('/diagramObjectStyles');
        });
    }


    cancel(){
        this.props.history.push('/diagramObjectStyles');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DiagramObjectStyle</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagramObjectStyle}>Save</button>
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

export default UpdateDiagramObjectStyleComponent
