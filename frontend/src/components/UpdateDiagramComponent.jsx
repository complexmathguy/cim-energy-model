import React, { Component } from 'react'
import DiagramService from '../services/DiagramService';

class UpdateDiagramComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                orientation: '',
                x1InitialView: '',
                x2InitialView: '',
                y1InitialView: '',
                y2InitialView: ''
        }
        this.updateDiagram = this.updateDiagram.bind(this);

        this.changeorientationHandler = this.changeorientationHandler.bind(this);
        this.changex1InitialViewHandler = this.changex1InitialViewHandler.bind(this);
        this.changex2InitialViewHandler = this.changex2InitialViewHandler.bind(this);
        this.changey1InitialViewHandler = this.changey1InitialViewHandler.bind(this);
        this.changey2InitialViewHandler = this.changey2InitialViewHandler.bind(this);
    }

    componentDidMount(){
        DiagramService.getDiagramById(this.state.id).then( (res) =>{
            let diagram = res.data;
            this.setState({
                orientation: diagram.orientation,
                x1InitialView: diagram.x1InitialView,
                x2InitialView: diagram.x2InitialView,
                y1InitialView: diagram.y1InitialView,
                y2InitialView: diagram.y2InitialView
            });
        });
    }

    updateDiagram = (e) => {
        e.preventDefault();
        let diagram = {
            diagramId: this.state.id,
            orientation: this.state.orientation,
            x1InitialView: this.state.x1InitialView,
            x2InitialView: this.state.x2InitialView,
            y1InitialView: this.state.y1InitialView,
            y2InitialView: this.state.y2InitialView
        };
        console.log('diagram => ' + JSON.stringify(diagram));
        console.log('id => ' + JSON.stringify(this.state.id));
        DiagramService.updateDiagram(diagram).then( res => {
            this.props.history.push('/diagrams');
        });
    }

    changeorientationHandler= (event) => {
        this.setState({orientation: event.target.value});
    }
    changex1InitialViewHandler= (event) => {
        this.setState({x1InitialView: event.target.value});
    }
    changex2InitialViewHandler= (event) => {
        this.setState({x2InitialView: event.target.value});
    }
    changey1InitialViewHandler= (event) => {
        this.setState({y1InitialView: event.target.value});
    }
    changey2InitialViewHandler= (event) => {
        this.setState({y2InitialView: event.target.value});
    }

    cancel(){
        this.props.history.push('/diagrams');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Diagram</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> orientation: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x1InitialView: </label>
                                            #formFields( $attribute, 'update')
                                            <label> x2InitialView: </label>
                                            #formFields( $attribute, 'update')
                                            <label> y1InitialView: </label>
                                            #formFields( $attribute, 'update')
                                            <label> y2InitialView: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDiagram}>Save</button>
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

export default UpdateDiagramComponent
